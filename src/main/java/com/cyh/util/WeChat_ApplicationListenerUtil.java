package com.cyh.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 項目启动后执行的方法
 */
@Component
public class WeChat_ApplicationListenerUtil implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //添加监听：项目启动完成之后启动一个线程按时获取access_token
        /*ApplicationContext ac = event.getApplicationContext();
        WeChat_GetAccessToken weChat_GetAccessToken = ac.getBean(WeChat_GetAccessToken.class);
        Thread thread = new Thread(weChat_GetAccessToken);
        thread.start();*/
    }
}
