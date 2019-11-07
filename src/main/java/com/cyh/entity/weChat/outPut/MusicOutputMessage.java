package com.cyh.entity.weChat.outPut;

import com.cyh.util.wechat.WeChat_Util;
/**
 * 回复音乐消息
 * @author Administrator
 *
 */
public class MusicOutputMessage extends BaseOutMessage {
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}

	@Override
	public String getMsgType() {
		return WeChat_Util.RESP_MESSAGE_TYPE_MUSIC.toString();
	}
}
