package com.cyh.controller;

import com.cyh.service.WeChatService;
import com.cyh.util.WeChat_SignUtil;
import com.cyh.util.WeChat_Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Controller
@RequestMapping(value ="/getAndPost")
public class WeChatController {

    @RequestMapping(method = RequestMethod.GET)
    public void get(HttpServletRequest request, HttpServletResponse response){
        // 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = null;
        try {
            out = response.getWriter();
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败
            //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
            if (WeChat_SignUtil.checkSignature(signature, timestamp, nonce)) {
                out.print(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public void post(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //消息来源可靠性验证
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");       // 随机数
        if (!WeChat_SignUtil.checkSignature(signature, timestamp, nonce)) {
            //消息不可靠，直接返回
            response.getWriter().write("");
            return;
        }
        //用户每次向公众号发送消息、或者产生自定义菜单点击事件时，响应URL将得到推送
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/xml");
            //调用parseXml方法解析请求消息
            Map<String, String> map = WeChat_Util.parseXml(request, response);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println("-----------");
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
                System.out.println("-----------");
            }
            String MsgType = map.get("MsgType");
            String results = null;//处理输入消息，返回结果的xml
            if(WeChat_Util.REQ_MESSAGE_TYPE_EVENT.equals(MsgType)){ // 事件类型的消息
                results = WeChatService.parseEvent(map);
            }else{
                results = WeChatService.parseMessage(map);
            }
            //返回封装的xml
            System.out.println("返回封装的xml"+results);
            response.getWriter().write(results);
        } catch (Exception ex) {
            response.getWriter().write("");
        }

    }
}
