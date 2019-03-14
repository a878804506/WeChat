package com.cyh.entity.weChat.message;

public class VoiceMessage extends BaseMessage {
    // 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId;
    // 语音格式，如amr，speex等
    private String Format;
    // 语音识别结果，使用UTF8编码
    private String Recognition;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }

}
