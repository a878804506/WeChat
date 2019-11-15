package com.cyh.Mapper;

import com.cyh.entity.Picture;
import com.cyh.entity.PictureGroup;
import com.cyh.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface MarryMapper {

    User loginUser(User user);

    List<PictureGroup> getMarryPictureGroupList(@Param("isLogin") boolean isLogin);

    PictureGroup getPictureGroupById(@Param("pictureGroupId") Integer pictureGroupId);

    void addPictureGroupCountById(@Param("pictureGroupId") Integer pictureGroupId, @Param("pictureGroupLookCount") Integer pictureGroupLookCount);

    List<Picture> getMarryPictureListByGroupId(@Param("pictureGroupId") Integer pictureGroupId);

    void submitVisitor(@Param("name") String name, @Param("phone") String phone, @Param("peoples") String peoples, @Param("ip") String ip);

    List<Map<String, String>> getAllVisitors();
}
