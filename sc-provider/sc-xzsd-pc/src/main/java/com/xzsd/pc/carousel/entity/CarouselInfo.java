package com.xzsd.pc.carousel.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CarouselInfo {
    /**
     * 轮播图编号
     */
    private String caroCode;

    /**
     * 轮播图序号
     */
    private String caroNum;

    /**
     * 图片路径
     */
    private String path;

    /**
     * 轮播图状态态(0启用 1禁用)
     */
    private String caroStatus;

    /**
     *有效时间起
     */
    private String startTime;

    /**
     * 有效时间止
     */
    private String endTime;

    /**
     * 商品编号
     */
    private String comCode;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDelete;
    /**
     * 创建者
     */
    private String createUser;
    /**
     * 创建时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date createTime;
    /**
     * 更新者
     */
    private String updateUser;
    /**
     * 更新时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date updateTime;
    /**
     * 版本号
     */
    private String version;

    /**
     * 商品名称
     */
    private String comName;

    /**
     *商品状态
     */
    private String comStatus;

    /**
     * 一级分类编号
     */
    private String firstSortCode;

    /**
     * 一级分类名称
     */
    private String firstSortName;

    /**
     * 二级分类编号
     */
    private String secondSortCode;

    /**
     * 二级分类名称
     */
    private String secondSortName;

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComStatus() {
        return comStatus;
    }

    public void setComStatus(String comStatus) {
        this.comStatus = comStatus;
    }

    public String getFirstSortCode() {
        return firstSortCode;
    }

    public void setFirstSortCode(String firstSortCode) {
        this.firstSortCode = firstSortCode;
    }

    public String getFirstSortName() {
        return firstSortName;
    }

    public void setFirstSortName(String firstSortName) {
        this.firstSortName = firstSortName;
    }

    public String getSecondSortCode() {
        return secondSortCode;
    }

    public void setSecondSortCode(String secondSortCode) {
        this.secondSortCode = secondSortCode;
    }

    public String getSecondSortName() {
        return secondSortName;
    }

    public void setSecondSortName(String secondSortName) {
        this.secondSortName = secondSortName;
    }

    public String getCaroCode() {
        return caroCode;
    }

    public void setCaroCode(String caroCode) {
        this.caroCode = caroCode;
    }

    public String getCaroNum() {
        return caroNum;
    }

    public void setCaroNum(String caroNum) {
        this.caroNum = caroNum;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCaroStatus() {
        return caroStatus;
    }

    public void setCaroStatus(String caroStatus) {
        this.caroStatus = caroStatus;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
