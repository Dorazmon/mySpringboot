package com.zhang.springboot.jwt;

public enum SystemConstant {
    JWT_ERRCODE_EXPIRE("过期"),JWT_ERRCODE_FAIL("错误"),JWT_SECERT("加密");
    private String desc;

    private SystemConstant(String name){
        this.desc = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
