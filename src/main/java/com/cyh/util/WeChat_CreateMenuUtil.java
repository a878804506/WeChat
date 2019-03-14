package com.cyh.util;

import com.alibaba.fastjson.JSON;
import com.cyh.entity.weChat.Menu.Button;
import com.cyh.entity.weChat.Menu.ClickButton;
import com.cyh.entity.weChat.Menu.Menu;
import com.cyh.entity.weChat.Menu.ViewButton;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeChat_CreateMenuUtil {
    //创建菜单的url
    public static String CreateMenusUrl ;

    //查询菜单的url
    public static String QueryMenusUrl ;

    //删除菜单的url
    public static String DeleteMenusUrl ;

    @Value("${WeChat.CreateMenusUrl}")
    public void setCreateMenusUrl(String thisCreateMenusUrl) {
        CreateMenusUrl = thisCreateMenusUrl;
    }

    @Value("${WeChat.QueryMenusUrl}")
    public void setQueryMenusUrl(String thisQueryMenusUrl) {
        QueryMenusUrl = thisQueryMenusUrl;
    }

    @Value("${WeChat.DeleteMenusUrl}")
    public void setDeleteMenusUrl(String thisDeleteMenusUrl) {
        DeleteMenusUrl = thisDeleteMenusUrl;
    }

    public static void CreateMenus(){
        //查询菜单
        QueryMenusUrl = QueryMenusUrl.replace("ACCESS_TOKEN",WeChat_GetAccessToken.accessToken.getAccessToken());
        String queryResult = WeChat_GetAccessToken.getHttpsResponse(QueryMenusUrl,"","");
        System.out.println("查询得到的结果："+queryResult);

        //创建菜单
        CreateMenusUrl = CreateMenusUrl.replace("ACCESS_TOKEN",WeChat_GetAccessToken.accessToken.getAccessToken());
        String createResult = WeChat_GetAccessToken.getHttpsResponse(CreateMenusUrl,"",initMenu());
        System.out.println("创建得到的结果："+createResult);

    }

    public static String initMenu(){
        Menu menu = new Menu();
        ClickButton button11 = new ClickButton();
        button11.setName("了解教育");
        button11.setType("click");
        button11.setKey("11");

        ClickButton button12 = new ClickButton();
        button12.setName("加入教育");
        button12.setType("click");
        button12.setKey("12");

        ViewButton button21 = new ViewButton();
        button21.setName("教育官网");
        button21.setType("view");
        button21.setUrl("http://www.jerehedu.com");

        ViewButton button22 = new ViewButton();
        button22.setName("教育新闻网");
        button22.setType("view");
        button22.setUrl("http://www.jredu100.com");

        ClickButton button31 = new ClickButton();
        button31.setName("杰小瑞");
        button31.setType("click");
        button31.setKey("31");

        Button button1 = new Button();
        button1.setName("教育"); //将11/12两个button作为二级菜单封装第一个一级菜单
        button1.setSub_button(new Button[]{button11,button12});

        Button button2 = new Button();
        button2.setName("相关网址"); //将21/22两个button作为二级菜单封装第二个二级菜单
        button2.setSub_button(new Button[]{button11,button12});

        menu.setButton(new Button[]{button1,button2,button31});// 将31Button直接作为一级菜单
        return JSON.toJSONString(menu);
    }
}
