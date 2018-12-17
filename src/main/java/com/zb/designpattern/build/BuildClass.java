package com.zb.designpattern.build;

/**
 * Created by zhangbin on 2018/8/21.
 */
public class BuildClass {

    private Person person;

    private BuildClass(){
        person = new Person();
    }

    public static BuildClass createBuild(){
        return new BuildClass();
    }

    public BuildClass buildHead(String head){
        person.setHead(head);
        return this;
    }

    public BuildClass buildBody(String body){
        person.setBody(body);
        return this;
    }

    public BuildClass buildFoot(String foot){
        person.setFoot(foot);
        return this;
    }

    public Person build(){
        return person;
    }

}
