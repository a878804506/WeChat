package com.cyh.service;

import com.cyh.Mapper.MarryMapper;
import com.cyh.common.ResultJSON;
import com.cyh.entity.Picture;
import com.cyh.entity.PictureGroup;
import com.cyh.entity.User;
import com.cyh.util.EncryptionAndDecryptionUtil;
import com.cyh.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MarryService {

    @Autowired
    private MarryMapper marryMapper;

    public ResultJSON marrylogin(User user) {
        //密码加密后再去数据库进行匹配
        try {
            user.setPassword(EncryptionAndDecryptionUtil.getEncryptionPassword(user.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultJSON(100, "服务器内部错误！");
        }
        User loginUser = marryMapper.loginUser(user);

        if (loginUser == null) { // 如果数据库查找不到该用户说明用户名或者密码错误！
            return new ResultJSON(100, "账号或密码错误,请重试！");
        } else if ("0".equals(loginUser.getStruts())) {
            return new ResultJSON(100, user.getUserName() + "账号已被冻结，请联系管理员！");
        } else {
            String token = JWTUtil.sign(loginUser.getId());
            Map result = new HashMap();
            result.put("token", token);
            result.put("id", loginUser.getId());
            result.put("username", loginUser.getUserName());
            result.put("nickname", loginUser.getNickName());
            return new ResultJSON(200, "登陆成功", result);
        }
    }

    public ResultJSON getMarryPictureGroupList(boolean isLogin) {
        List<PictureGroup> marryPictureGroupList = marryMapper.getMarryPictureGroupList(isLogin);
        if (isLogin) {
            for (PictureGroup temp : marryPictureGroupList) {
                temp.setPictureGroupShowPath(temp.getPictureGroupRealPath());
                temp.setPictureGroupPath("");
            }
        } else {
            for (PictureGroup temp : marryPictureGroupList) {
                temp.setPictureGroupShowPath(temp.getPictureGroupPath());
                temp.setPictureGroupRealPath("");
            }
        }
        return new ResultJSON(200, "查询成功", marryPictureGroupList);
    }

    public void toPictureGroupCountAdd(Integer pictureGroupId) {
        PictureGroup pictureGroup = marryMapper.getPictureGroupById(pictureGroupId);
        marryMapper.addPictureGroupCountById(pictureGroupId, pictureGroup.getPictureGroupLookCount() + 1);
    }

    public ResultJSON getMarryPictureListByGroupId(Integer pictureGroupId) {
        PictureGroup pictureGroup = marryMapper.getPictureGroupById(pictureGroupId);
        List<Picture> pictureList = marryMapper.getMarryPictureListByGroupId(pictureGroupId);
        Map result = new HashMap();
        result.put("pictureGroup", pictureGroup);
        result.put("pictureList", pictureList);
        return new ResultJSON(200, "查询成功", result);
    }

    public ResultJSON getPictureGroupByGroupId(Integer pictureGroupId) {
        PictureGroup pictureGroup = marryMapper.getPictureGroupById(pictureGroupId);
        return new ResultJSON(200, "查询成功", pictureGroup);
    }

    public ResultJSON submitVisitor(String name, String phone, String peoples, String ip) {
        List<Map<String,String>> visitors = marryMapper.getAllVisitors();
        for(Map<String,String> temp : visitors){
            String tempIp = temp.get("ip");
            if(tempIp.equals(ip)){
                return new ResultJSON(100, "你已经提交了来客登记，感谢支持！");
            }
        }
        try {
            marryMapper.submitVisitor(name, phone, peoples, ip);
            return new ResultJSON(200, "提交成功");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultJSON(100, e.getMessage());
        }
    }

    public ResultJSON submitAdvise(String advise, String call) {
        try {
            marryMapper.submitAdvise(advise, call);
            return new ResultJSON(200, "提交成功");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultJSON(100, e.getMessage());
        }
    }
}
