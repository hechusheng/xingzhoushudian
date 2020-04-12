package com.neusoft.webauth.menu.entity;

import java.util.Date;

/**
 * @ClassName MenuBtn
 * @Description
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
public class MenuBtn {

    private String buttonCode;

    private String buttonName;

    private String buttonUrl;

    private String buttonStyle;

    private String menuCode;

    private String remark;

    private int level;

    private String isDeleted;

    private int sortNo;

    private String id;

    private String createBy;

    private String lastModifiedBy;

    private Date gmtCreate;

    private Date gmtModified;

    private String parentButtonCode;
    /**
     * 角色代码
     */
    private String roleCode;
    /**
     * 登录账号
     */
    private String userAcct;

    private String[] buttonCodes;

    private String[] menuCodes;

    private String[] roleCodes;

    private String authCode;

    /**
     * 版本
     */
    private String version;

    /**
     * 菜单范围代码
     */
    private String menuAuthCode;

    public String getButtonCode() {
        return buttonCode;
    }

    public void setButtonCode(String buttonCode) {
        this.buttonCode = buttonCode;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonUrl() {
        return buttonUrl;
    }

    public void setButtonUrl(String buttonUrl) {
        this.buttonUrl = buttonUrl;
    }

    public String getButtonStyle() {
        return buttonStyle;
    }

    public void setButtonStyle(String buttonStyle) {
        this.buttonStyle = buttonStyle;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getParentButtonCode() {
        return parentButtonCode;
    }

    public void setParentButtonCode(String parentButtonCode) {
        this.parentButtonCode = parentButtonCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String[] getButtonCodes() {
        return buttonCodes;
    }

    public void setButtonCodes(String[] buttonCodes) {
        this.buttonCodes = buttonCodes;
    }

    public String[] getMenuCodes() {
        return menuCodes;
    }

    public void setMenuCodes(String[] menuCodes) {
        this.menuCodes = menuCodes;
    }

    public String[] getRoleCodes() {
        return roleCodes;
    }

    public void setRoleCodes(String[] roleCodes) {
        this.roleCodes = roleCodes;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMenuAuthCode() {
        return menuAuthCode;
    }

    public void setMenuAuthCode(String menuAuthCode) {
        this.menuAuthCode = menuAuthCode;
    }
}
