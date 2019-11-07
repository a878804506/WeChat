package com.cyh.util.wechat;

import com.cyh.entity.weChat.message.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeChat_Util {
    /*
     * 文本消息
     */
    public static final String TEXT_MESSAGE = "text";
    /*
     * 图片消息
     */
    public static final String IMAGE_MESSAGE = "image";
    /*
     * 语音消息
     */
    public static final String VOICE_MESSAGE = "voice";
    /*
     * 视频消息
     */
    public static final String VIDEO_MESSAGE = "video";
    /*
     * 小视频消息消息
     */
    public static final String SHORTVIDEO_MESSAGE = "shortvideo";
    /*
     * 地理位置消息
     */
    public static final String POSOTION_MESSAGE = "location";
    /*
     * 链接消息
     */
    public static final String LINK_MESSAGE = "link";
    /*
     * 音乐消息
     */
    public static final String MUSIC_MESSAGE = "music";
    /*
     * 图文消息
     */
    public static final String IMAGE_TEXT_MESSAGE = "news";
    /*
     * 请求消息类型：事件推送
     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";
    /*
     * 事件类型：subscribe(订阅)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    /*
     * 事件类型：unsubscribe(取消订阅)
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    /*
     * 事件类型：scan(用户已关注时的扫描带参数二维码)
     */
    public static final String EVENT_TYPE_SCAN = "scan";
    /*
     * 事件类型：LOCATION(上报地理位置)
     */
    public static final String EVENT_TYPE_LOCATION = "location";
    /*
     * 事件类型：CLICK(自定义菜单)
     */
    public static final String EVENT_TYPE_CLICK = "click";

    /*
     * 响应消息类型：文本
     */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";
    /*
     * 响应消息类型：图片
     */
    public static final String RESP_MESSAGE_TYPE_IMAGE = "image";
    /*
     * 响应消息类型：语音
     */
    public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
    /*
     * 响应消息类型：视频
     */
    public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
    /*
     * 响应消息类型：音乐
     */
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
    /*
     * 响应消息类型：图文
     */
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";


    /**
     * @Title parseXml
     * @Description 将用户的xml消息提取成map key value 类型
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public static Map<String, String> parseXml(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();
        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        // 遍历所有子节点
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        // 释放资源
        inputStream.close();
        inputStream = null;
        return map;
    }

    /**
     * 响应消息转换成xml返回
     * 文本对象转换成xml
     */
    public static String textMessageToXml(TextMessage textMessage) {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }
    /**
     * 语音对象的转换成xml
     *
     */
    public static String voiceMessageToXml(VoiceMessage voiceMessage) {
        xstream.alias("xml", voiceMessage.getClass());
        return xstream.toXML(voiceMessage);
    }

    /**
     * 视频对象的转换成xml
     *
     */
    public static String videoMessageToXml(VideoMessage videoMessage) {
        xstream.alias("xml", videoMessage.getClass());
        return xstream.toXML(videoMessage);
    }

    /**
     * 图片对象转换成xml
     *
     */
    public static String imageMessageToXml(ImageMessage imageMessage)
    {
        xstream.alias("xml",imageMessage.getClass());
        return xstream.toXML(imageMessage);

    }

    /**
     * 链接对象转换成xml
     *
     */
    public static String linkMessageToXml(LinkMessage linkMessage)
    {
        xstream.alias("xml",linkMessage.getClass());
        return xstream.toXML(linkMessage);

    }

    /**
     * 地理位置对象转换成xml
     *
     */
    public static String locationMessageToXml(LocationMessage locationMessage)
    {
        xstream.alias("xml",locationMessage.getClass());
        return xstream.toXML(locationMessage);

    }

    /**
     * 拓展xstream，使得支持CDATA块
     *
     */
    private static XStream xstream = new XStream(new XppDriver(){
        public HierarchicalStreamWriter createWriter(Writer out){
            return new PrettyPrintWriter(out){
                //对所有的xml节点的转换都增加CDATA标记
                boolean cdata = true;

                @SuppressWarnings("unchecked")
                public void startNode(String name,Class clazz){
                    super.startNode(name,clazz);
                }

                protected void writeText(QuickWriter writer, String text){
                    if(cdata){
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    }else{
                        writer.write(text);
                    }
                }
            };
        }
    });

}
