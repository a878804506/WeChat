package com.cyh.entity.weChat.outPut;

import com.cyh.util.WeChat_Util;
/**
 * 语音回复消息
 * @author Administrator
 *
 */
public class VoiceOutputMessage extends BaseOutMessage{
    private Voice voice;
    
	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	@Override
	public String getMsgType() {
		return WeChat_Util.RESP_MESSAGE_TYPE_VOICE.toString();
	}
}
