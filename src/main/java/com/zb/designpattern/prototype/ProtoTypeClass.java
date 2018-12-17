package com.zb.designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangbin on 2018/8/21.
 */
public class ProtoTypeClass {
    public static void main(String[] args){
        List<String> valueList = new ArrayList<>();
        valueList.add("1");
        valueList.add("2");
        valueList.add("3");

        ProtoTypeSubBean protoTypeSubBean = new ProtoTypeSubBean();
        protoTypeSubBean.setName("lisi");

        ProtoTypeBean protoTypeBean = new ProtoTypeBean();
        protoTypeBean.setName("zhangsna");
        protoTypeBean.setProtoTypeSubBean(protoTypeSubBean);
        protoTypeBean.setValueList(valueList);

        ProtoTypeBean protoTypeBean1 = protoTypeBean.clone();

        System.out.println(protoTypeBean.getName());
        System.out.println(protoTypeBean1.getName());

        System.out.println(protoTypeBean.getProtoTypeSubBean());
        System.out.println(protoTypeBean1.getProtoTypeSubBean());

        protoTypeBean1.getValueList().add("4");

        System.out.println(protoTypeBean.getValueList());
        System.out.println(protoTypeBean1.getValueList());
    }
}
