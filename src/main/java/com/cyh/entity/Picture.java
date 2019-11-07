package com.cyh.entity;

public class Picture {
    private Integer pictureId;
    private Integer pictureGroupId;
    private String pictureRealPath;
    private String pictureRealFullPath;
    private String pictureBasePath;

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getPictureGroupId() {
        return pictureGroupId;
    }

    public void setPictureGroupId(Integer pictureGroupId) {
        this.pictureGroupId = pictureGroupId;
    }

    public String getPictureRealPath() {
        return pictureRealPath;
    }

    public void setPictureRealPath(String pictureRealPath) {
        this.pictureRealPath = pictureRealPath;
    }

    public String getPictureBasePath() {
        return pictureBasePath;
    }

    public void setPictureBasePath(String pictureBasePath) {
        this.pictureBasePath = pictureBasePath;
    }

    public String getPictureRealFullPath() {
        return pictureRealFullPath;
    }

    public void setPictureRealFullPath(String pictureRealFullPath) {
        this.pictureRealFullPath = pictureRealFullPath;
    }
}
