package com.neusoft.webauth.user.entity;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * <p>用户查询数据库接口</p>
 * <p>创建日期：2018-01-10</p>
 *
 * @author 李万迪 liwandi@neusoft.com
 */
public class UserParams {
    /**
     * 用户代码
     */
    @NotNull(message = "用户代码不能为空")
    private String userCode;

    /**
     * 用户名称
     */
    @NotNull(message = "用户名称不能为空")
    private String userName;
    /**
     * 用户登录名
     */
    @NotNull(message = "用户登录名不能为空")
    private String userAcct;
    /**
     * 用户密码
     */
    @NotNull(message = "密码不能为空", groups = AddUserGroup.class)
    private String userPwd;
    /**
     * 管理员标记
     */
    @NotNull(message = "管理员标记不能为空")
    private Integer isAdmin;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 性别
     */
    private int sex;
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
    @NotNull(message = "部门不能为空")
    private String deptCode;
    /**
     * 备注
     */
    private String remark;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * UUID
     */
    private String id;
    /**
     * 序号
     */
    private int sortNo;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新时间
     */
    private Date gmtModified;
    /**
     * 更新者
     */
    private String lastModifiedBy;

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

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
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

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
