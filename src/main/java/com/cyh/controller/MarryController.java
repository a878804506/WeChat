package com.cyh.controller;

import com.alibaba.fastjson.JSON;
import com.cyh.common.ResultJSON;
import com.cyh.entity.User;
import com.cyh.service.MarryService;
import com.cyh.util.GetUserIpUtil;
import com.cyh.util.JWTUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MarryController {

    @Autowired
    private MarryService marryService;

    /**
     * 结婚首页
     *
     * @return
     */
    @RequestMapping("/marry")
    public String myMarry() {
        return "marry";
    }

    /**
     * 某组照片详情
     *
     * @return
     */
    @RequestMapping("/marrypicture")
    public String marrypicture(Integer pictureGroupId, Integer type) {
        if (null == pictureGroupId || null == type) {
            return "marry";
        }
        // 增加访问次数
        marryService.toPictureGroupCountAdd(pictureGroupId);
        //判断跳转的哪个页面
        if (type.equals(1)) {
            // 照片
            return "marrypicture";
        } else {
            // 文字（一封信）
            return "email";
        }
    }

    /**
     * 来客登记
     *
     * @return
     */
    @RequestMapping("/visitorRegistration")
    public String visitorRegistration() {
        return "visitorRegistration";
    }

    /**
     * 你的建议
     *
     * @return
     */
    @RequestMapping("/advise")
    public String advise() {
        return "advise";
    }

    @ResponseBody
    @RequestMapping(value = "/marrylogin", method = RequestMethod.POST)
    public String marrylogin(User user) {
        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
            return JSON.toJSONString(new ResultJSON(100, "用户名密码不能为空"));
        }
        ResultJSON marrylogin = marryService.marrylogin(user);
        return JSON.toJSONString(marrylogin);
    }

    @ResponseBody
    @RequestMapping(value = "/marryloginout", method = RequestMethod.POST)
    public String marryloginout(HttpServletRequest request) throws ServletException {
        System.out.println("用户退出！");
        request.logout();
        return JSON.toJSONString(new ResultJSON(200, "注销成功"));
    }

    /**
     * 首页获取照片组
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getMarryPictureGroupList", method = RequestMethod.GET)
    public String getMarryPictureGroupList(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        boolean isLogin = JWTUtil.checkToken(token);
        ResultJSON result = marryService.getMarryPictureGroupList(isLogin);
        return JSON.toJSONString(result);
    }

    /**
     * 根据组id ，获取照片列表
     *
     * @param pictureGroupId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getMarryPictureListByGroupId", method = RequestMethod.GET)
    public String getMarryPictureListByGroupId(Integer pictureGroupId) {
        ResultJSON result = marryService.getMarryPictureListByGroupId(pictureGroupId);
        return JSON.toJSONString(result);
    }

    /**
     * 根据组id ，获取 pictureGroup 实体
     *
     * @param pictureGroupId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getPictureGroupByGroupId", method = RequestMethod.GET)
    public String getPictureGroupByGroupId(Integer pictureGroupId) {
        ResultJSON result = marryService.getPictureGroupByGroupId(pictureGroupId);
        return JSON.toJSONString(result);
    }

    /**
     * 来客登记
     *
     * @param name    姓名
     * @param phone   电话
     * @param peoples 来的人数
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/submitVisitor", method = RequestMethod.POST)
    public String submitVisitor(HttpServletRequest request, String name, String phone, String peoples) {
        String ip = GetUserIpUtil.getUserIpAddress(request);
        ResultJSON result = marryService.submitVisitor(name, phone, peoples, ip);
        return JSON.toJSONString(result);
    }

    /**
     * 你的建议
     *
     * @param advise
     * @param call
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/submitAdvise", method = RequestMethod.POST)
    public String submitAdvise(String advise, String call) {
        ResultJSON result = marryService.submitAdvise(advise, call);
        return JSON.toJSONString(result);
    }
}
