package com.cyh.Filter;

import com.cyh.util.JWTUtil;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器
 *
 */
@Component
public class MyFilter implements Filter {

    private static List<String> NOT_CHECK_URL = new ArrayList<>();

    static {
        // 跳转首页
        NOT_CHECK_URL.add("/marry");
        NOT_CHECK_URL.add("/marrylogin");
        NOT_CHECK_URL.add("/marryloginout");
        // 跳转的页面
        NOT_CHECK_URL.add("/marrypicture");
        // 获取照片分组列表
        NOT_CHECK_URL.add("/getMarryPictureGroupList");
        // wechat
        NOT_CHECK_URL.add("/wechat");
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        if(NOT_CHECK_URL.contains(requestURI)){
            chain.doFilter(request, response);
        }else if(requestURI.endsWith(".js") ||
                requestURI.endsWith(".jpg") ||
                requestURI.endsWith(".gif") ||
                requestURI.endsWith(".png") ||
                requestURI.endsWith(".css")){
            //允许加载静态文件
            chain.doFilter(request,response);
        }else{
            String token = request.getHeader("Authorization");
            if(JWTUtil.checkToken(token)){
                chain.doFilter(request, response);
            }else{
                response.sendRedirect("marry");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
