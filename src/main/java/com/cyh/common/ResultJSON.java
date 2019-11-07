package com.cyh.common;

/**
 * 前端请求结果返回实体类
 */
public class ResultJSON {

    // 定义返回值状态
    private Integer status;
    // 返回值数据
    private Object data;
    // 提示信息
    private String message;

    public ResultJSON(Integer status, String message){
        this.status = status;
        this.message = message;
    }

    public ResultJSON(Integer status, Object data){
        this.status = status;
        this.data = data;
    }

    public ResultJSON(Integer status, String message, Object data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
