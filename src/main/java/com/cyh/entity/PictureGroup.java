package com.cyh.entity;

/**
 * 照片组实体
 */
public class PictureGroup {
    private Integer pictureGroupId;
    private String pictureGroupName;
    private String pictureGroupPath;
    private String pictureGroupRealPath;
    private Integer pictureGroupUserId;
    private String pictureGroupShowPath;
    private String pictureGroupBasePath;
    private Integer pictureGroupLookCount;
    private String by;

    public Integer getPictureGroupId() {
        return pictureGroupId;
    }

    public void setPictureGroupId(Integer pictureGroupId) {
        this.pictureGroupId = pictureGroupId;
    }

    public String getPictureGroupName() {
        return pictureGroupName;
    }

    public void setPictureGroupName(String pictureGroupName) {
        this.pictureGroupName = pictureGroupName;
    }

    public String getPictureGroupPath() {
        return pictureGroupPath;
    }

    public void setPictureGroupPath(String pictureGroupPath) {
        this.pictureGroupPath = pictureGroupPath;
    }

    public String getPictureGroupRealPath() {
        return pictureGroupRealPath;
    }

    public void setPictureGroupRealPath(String pictureGroupRealPath) {
        this.pictureGroupRealPath = pictureGroupRealPath;
    }

    public Integer getPictureGroupUserId() {
        return pictureGroupUserId;
    }

    public void setPictureGroupUserId(Integer pictureGroupUserId) {
        this.pictureGroupUserId = pictureGroupUserId;
    }

    public String getPictureGroupShowPath() {
        return pictureGroupShowPath;
    }

    public void setPictureGroupShowPath(String pictureGroupShowPath) {
        this.pictureGroupShowPath = pictureGroupShowPath;
    }

    public String getPictureGroupBasePath() {
        return pictureGroupBasePath;
    }

    public void setPictureGroupBasePath(String pictureGroupBasePath) {
        this.pictureGroupBasePath = pictureGroupBasePath;
    }

    public Integer getPictureGroupLookCount() {
        return pictureGroupLookCount;
    }

    public void setPictureGroupLookCount(Integer pictureGroupLookCount) {
        this.pictureGroupLookCount = pictureGroupLookCount;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }
}
