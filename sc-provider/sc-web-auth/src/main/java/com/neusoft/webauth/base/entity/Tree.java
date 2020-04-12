package com.neusoft.webauth.base.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门：软件开发事业部
 * 描述：略
 * 作成者：印政权
 * 作成时间：2018/3/12
 */
public class Tree {

    private String id;
    private String label;
    private String index;
    private Object attributes;
    private List<Tree> children = new ArrayList<Tree>();
    private String pid;
    private String code;
    private String type;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
