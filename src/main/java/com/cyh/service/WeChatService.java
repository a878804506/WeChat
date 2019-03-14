package com.cyh.service;

import com.cyh.entity.weChat.message.TextMessage;
import com.cyh.util.WeChat_Util;
import com.cyh.util.WeChat_XmlUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理接收信息和回复消息的服务类接口
 *
 * @author Administrator
 *
 */
public class WeChatService {
    // 处理微信发来的请求 map 消息业务处理分发
    public static String parseMessage(Map<String, String> map) {
        String respXml = null;
        try {
            // 发送方帐号（open_id）
            String fromUserName = map.get("FromUserName");
            // 开发者微信号(公众账号)
            String toUserName = map.get("ToUserName");
            // 取得消息类型
            String MsgType = map.get("MsgType");
            // 发现直接把要返回的信息直接封装成replyMap集合，然后转换成 xml文件，是不是实体类可以不用了
            Map<String, String> replyMap = new HashMap<>();
            replyMap.put("ToUserName", fromUserName);
            replyMap.put("FromUserName", toUserName);
            replyMap.put("CreateTime", String.valueOf(new Date().getTime()));
            if (MsgType.equals(WeChat_Util.TEXT_MESSAGE)) {
                // 封装文本返回消息
                TextMessage textMessage = new TextMessage();
                textMessage.setToUserName(fromUserName);
                textMessage.setFromUserName(toUserName);
                textMessage.setCreateTime(new Date().getTime());
                textMessage.setContent("您发送的是文本消息内容是："+ map.get("Content")+
                        "<a href = \"http://148.70.60.231/WeChat/index\">水务管理系统</a>");

                textMessage.setMsgType(WeChat_Util.TEXT_MESSAGE);
                respXml = WeChat_Util.textMessageToXml(textMessage);
            } /*else if (MsgType.equals(WeChatUtil.IMAGE_MESSAGE)) {

            } else if (MsgType.equals(WeChatUtil.VOICE_MESSAGE)) {
                // 以下方式根据需要来操作
                replyMap.put("MsgType", WeChatUtil.RESP_MESSAGE_TYPE_TEXT);
                replyMap.put("Content", "您发送的是语音消息");
                respXml = WeChat_XmlUtil.xmlFormat(replyMap, true);
            } else if (MsgType.equals(WeChatUtil.VIDEO_MESSAGE)) {
                replyMap.put("MsgType", WeChatUtil.RESP_MESSAGE_TYPE_TEXT);
                replyMap.put("Content", "您发送的是视频消息");
                respXml = WeChat_XmlUtil.xmlFormat(replyMap, true);
            } else if (MsgType.equals(WeChatUtil.SHORTVIDEO_MESSAGE)) {
                replyMap.put("MsgType", WeChatUtil.RESP_MESSAGE_TYPE_TEXT);
                replyMap.put("Content", "您发送的是小视频消息");
                respXml = WeChat_XmlUtil.xmlFormat(replyMap, true);
            } else if (MsgType.equals(WeChatUtil.POSOTION_MESSAGE)) {
                replyMap.put("MsgType", WeChatUtil.RESP_MESSAGE_TYPE_TEXT);
                replyMap.put("Content", "您发送的是地理位置消息");
                respXml = WeChat_XmlUtil.xmlFormat(replyMap, true);
            } else if (MsgType.equals(WeChatUtil.LINK_MESSAGE)) {
                replyMap.put("MsgType", WeChatUtil.RESP_MESSAGE_TYPE_TEXT);
                replyMap.put("Content", "您发送的是链接消息");
                respXml = WeChat_XmlUtil.xmlFormat(replyMap, true);
            }*/else{
                TextMessage textMessage = new TextMessage();
                textMessage.setToUserName(fromUserName);
                textMessage.setFromUserName(toUserName);
                textMessage.setCreateTime(new Date().getTime());
                textMessage.setContent("不回复文本以外的消息，感谢使用！");
                textMessage.setMsgType(WeChat_Util.TEXT_MESSAGE);
                respXml = WeChat_Util.textMessageToXml(textMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }

    // 事件消息业务分发
    public static String parseEvent(Map<String, String> map) {
        String respXml = null;
        try {
            // 发送方帐号
            String fromUserName = map.get("FromUserName");
            // 开发者微信号
            String toUserName = map.get("ToUserName");
            // 取得消息类型
            String MsgType = map.get("MsgType");
            //获取事件类型
            String eventType = map.get("Event");

            // 发现直接把要返回的信息直接封装成replyMap集合，然后转换成 xml文件，是不是实体类可以不用了
            Map<String, String> replyMap = new HashMap<String, String>();
            replyMap.put("ToUserName", fromUserName);
            replyMap.put("FromUserName", toUserName);
            replyMap.put("CreateTime", String.valueOf(new Date().getTime()));
            if (eventType.equals(WeChat_Util.EVENT_TYPE_SUBSCRIBE)) {// 关注
                // 用map集合封装
                replyMap.put("MsgType", WeChat_Util.RESP_MESSAGE_TYPE_TEXT);
//                replyMap.put("Content", WeChatUtil.menuText());
                respXml = WeChat_XmlUtil.xmlFormat(replyMap, true);
            }
            if (eventType.equals(WeChat_Util.EVENT_TYPE_UNSUBSCRIBE)) {// 取消关注

            }
            if (eventType.equals(WeChat_Util.EVENT_TYPE_SCAN)) {// 用户已关注时的扫描带参数二维码

            }
            if (eventType.equals(WeChat_Util.EVENT_TYPE_LOCATION)) {// 上报地理位置

            }
            if (eventType.equals(WeChat_Util.EVENT_TYPE_CLICK)) {// 自定义菜单

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }

}
