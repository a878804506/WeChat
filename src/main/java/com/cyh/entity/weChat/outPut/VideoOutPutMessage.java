package com.cyh.entity.weChat.outPut;

import com.cyh.util.WeChat_Util;

/**
 * 回复视频消息
 * 
 * @author Administrator
 *
 */
public class VideoOutPutMessage extends BaseOutMessage {
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}

	@Override
	public String getMsgType() {
		return WeChat_Util.RESP_MESSAGE_TYPE_VIDEO.toString();
	}
}
