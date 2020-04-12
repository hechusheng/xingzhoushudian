package com.neusoft.support.sharding.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class UserInfo {
    /**
     * 用户代码
     */
    private String userCode;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户登录名
     */
    private String userAcct;
    /**
     * 用户密码
     */
    @JsonIgnore
    private String userPwd;
    /**
     * 管理员标记
     */
    private String adminFlag;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 性别
     */
    private String sex;
    /**
     * 固定电话
     */
    private String tel;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 部门代码
     */
    private String deptCode;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 岗位代码
     */
    private String  postCode;
    /**
     * 岗位名称
     */
    private String postName;
    private String postNameJ;
    /**
     * 备注
     */
    private String remark;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int delFlag;
    /**
     * UUID
     */
    private String uuid;
    /**
     * 序号
     */
    private int sortNo;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 创建者
     */
    private String createdBy;
    /**
     * 更新时间
     */
    private Date updatedTime;
    /**
     * 更新者
     */
    private String updatedBy;

    private String newPwd;

    private String version;

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostNameJ() {
        return postNameJ;
    }

    public void setPostNameJ(String postNameJ) {
        this.postNameJ = postNameJ;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(String adminFlag) {
        this.adminFlag = adminFlag;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
