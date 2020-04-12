package com.xzsd.pc.commoditySort.entity;

import java.util.Date;

/**
 * 二级分类实体类
 */
public class SecondClassSort {
    /**
     * 二级分类编号
     */
    private String secondSortCode;
    /**
     * 二级分类名称
     */
    private String secondSortName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 父级编号
     */
    private String parentCode;
    /**
     * 分类级别（1一级分类 2二级分类）
     */
    private int sortLevel;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDelete;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建者
     */
    private String createUser;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 更新者
     */
    private String updateUser;
    /**
     * 版本号
     */
    private String version;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public int getSortLevel() {
        return sortLevel;
    }

    public void setSortLevel(int sortLevel) {
        this.sortLevel = sortLevel;
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
