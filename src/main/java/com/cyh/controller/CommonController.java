package com.cyh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;

@Controller
public class CommonController {
    @RequestMapping("/zhengwen")
    public String zhengwen(){
        System.out.println(new Date());
        return "zhengwen";
    }

    @RequestMapping("/index")
    public String goHome(HashMap<String, Object> map){
        System.out.println(new Date());
        return "index";
    }
}
