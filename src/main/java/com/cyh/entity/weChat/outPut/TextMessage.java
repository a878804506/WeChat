package com.cyh.entity.weChat.outPut;

import com.cyh.util.wechat.WeChat_Util;

/**
 * 文本回复消息
 * 
 * @author Administrator
 *
 */
public class TextMessage extends BaseOutMessage {
	// 文本消息
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String getMsgType() {
		return WeChat_Util.RESP_MESSAGE_TYPE_TEXT.toString();
	}
}
