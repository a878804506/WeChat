package com.cyh.entity.weChat;

/**
 * 从微信服务器获取的 access_token
 */
public class AccessToken {

    private String accessToken;

    private int expiresin;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresin() {
        return expiresin;
    }

    public void setExpiresin(int expiresin) {
        this.expiresin = expiresin;
    }
}
