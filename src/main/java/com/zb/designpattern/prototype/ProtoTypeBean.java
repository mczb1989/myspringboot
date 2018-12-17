package com.zb.designpattern.prototype;

import java.util.List;

/**
 * Created by zhangbin on 2018/8/21.
 */
public class ProtoTypeBean implements Cloneable {

    private String id;

    private String name;

    private ProtoTypeSubBean protoTypeSubBean;

    private List<String> valueList;

    public List<String> getValueList() {
        return valueList;
    }

    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }

    public ProtoTypeSubBean getProtoTypeSubBean() {
        return protoTypeSubBean;
    }

    public void setProtoTypeSubBean(ProtoTypeSubBean protoTypeSubBean) {
        this.protoTypeSubBean = protoTypeSubBean;
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

    public ProtoTypeBean clone(){
        ProtoTypeBean bean = null;
        try {
            bean = (ProtoTypeBean)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
