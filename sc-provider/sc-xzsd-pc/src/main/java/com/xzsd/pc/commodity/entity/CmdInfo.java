package com.xzsd.pc.commodity.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class CmdInfo implements Serializable {
    /**
     * 商品编号
     */
    private String comCode;

    /**
     * 商品名称
     */
    private String comName;

    /**
     * 商家名称
     */
    private String bussName;

    /**
     * 书号
     */
    private String comNum;

    /**
     * 商品库存
     */
    private String comStock;

    /**
     * 成本价
     */
    private String comCost;

    /**
     * 商品售价
     */
    private String comPrice;

    /**
     * 浏览量
     */
    private String pageViews;

    /**
     * 定价
     */
    private String fixedPrice;

    /**
     * 商品销量
     */
    private String comSales;

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

    /**
     *图片路径
     */
    private String picPath;

    /**
     * 商品状态(0在售 1下架 2未发布)
     */
    private String comStatus;

    /**
     * 商品介绍
     */
    private String comPresent;

    /**
     * 上架时间
     */
    private Date shelvesTime;

    /**
     * 广告词
     */
    private String advertisement;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版社
     */
    private String press;

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
     * 页码
     */
    private int pageSize;

    /**
     * 页数
     */
    private int pageNum;
    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getBussName() {
        return bussName;
    }

    public void setBussName(String bussName) {
        this.bussName = bussName;
    }

    public String getComNum() {
        return comNum;
    }

    public void setComNum(String comNum) {
        this.comNum = comNum;
    }

    public String getComStock() {
        return comStock;
    }

    public void setComStock(String comStock) {
        this.comStock = comStock;
    }

    public String getComCost() {
        return comCost;
    }

    public void setComCost(String comCost) {
        this.comCost = comCost;
    }

    public String getComPrice() {
        return comPrice;
    }

    public void setComPrice(String comPrice) {
        this.comPrice = comPrice;
    }

    public String getPageViews() {
        return pageViews;
    }

    public void setPageViews(String pageViews) {
        this.pageViews = pageViews;
    }

    public String getFixedPrice() {
        return fixedPrice;
    }

    public void setFixedPrice(String fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    public String getComSales() {
        return comSales;
    }

    public void setComSales(String comSales) {
        this.comSales = comSales;
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

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getComStatus() {
        return comStatus;
    }

    public void setComStatus(String comStatus) {
        this.comStatus = comStatus;
    }

    public String getComPresent() {
        return comPresent;
    }

    public void setComPresent(String comPresent) {
        this.comPresent = comPresent;
    }

    public Date getShelvesTime() {
        return shelvesTime;
    }

    public void setShelvesTime(Date shelvesTime) {
        this.shelvesTime = shelvesTime;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
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

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }




}
