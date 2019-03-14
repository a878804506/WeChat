package com.cyh.entity.weChat.Menu;

public class Button {
    //菜单的响应动作  view 是跳转网页  click是菜单的点击事件
    private String type;
    //菜单名称
    private String name;
    //子菜单
    private Button[] sub_button;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }
}
