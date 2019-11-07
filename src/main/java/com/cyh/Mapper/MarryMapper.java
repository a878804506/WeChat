package com.cyh.Mapper;

import com.cyh.entity.Picture;
import com.cyh.entity.PictureGroup;
import com.cyh.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface MarryMapper {

    User loginUser(User user);

    List<PictureGroup> getMarryPictureGroupList();

    PictureGroup getPictureGroupById(@Param("pictureGroupId")Integer pictureGroupId);

    void addPictureGroupCountById(@Param("pictureGroupId") Integer pictureGroupId,@Param("pictureGroupLookCount") Integer pictureGroupLookCount);

    List<Picture> getMarryPictureListByGroupId(@Param("pictureGroupId")Integer pictureGroupId);
}
