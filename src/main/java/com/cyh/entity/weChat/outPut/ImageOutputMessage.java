package com.cyh.entity.weChat.outPut;

import com.cyh.util.wechat.WeChat_Util;

/**
 * 图片输出内容
 * @author Administrator
 *
 */
public class ImageOutputMessage extends BaseOutMessage{
	private Image Image;
	public Image getImage() {
		return Image;
	}
	public void setImage(Image image) {
		Image = image;
	}
	@Override
	public String getMsgType() {
		return WeChat_Util.RESP_MESSAGE_TYPE_IMAGE.toString();
	}
}
