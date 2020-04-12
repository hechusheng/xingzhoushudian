package com.neusoft.project.demo.entity;

import com.neusoft.core.validate.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * <p>学生信息实体</p>
 * <p>创建日期：2018-05-14</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@ApiModel(description = "学生信息实体")
public class StudentEntity {

    @ApiModelProperty(hidden = true)
    @NotNull(message = "id不能为空", groups = UpdateGroup.class)
    private String id;

    @ApiModelProperty("名称")
    @NotNull(message = "名称不能为空")
    private String name;

    @ApiModelProperty("性别")
    @NotNull(message = "性别不能为空")
    private String sex;

    @ApiModelProperty("生日")
    @NotNull(message = "生日不能为空")
    private String birth;

    @ApiModelProperty("系别")
    @NotNull(message = "系别不能为空")
    private String department;

    @ApiModelProperty("地址")
    @NotNull(message = "地址不能为空")
    private String address;

    @ApiModelProperty(hidden = true)
    private Timestamp gmtCreate;

    @ApiModelProperty(hidden = true)
    private Timestamp gmtModified;

    @ApiModelProperty(hidden = true)
    private String operator;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }
}
