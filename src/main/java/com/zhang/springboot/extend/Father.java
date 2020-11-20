package com.zhang.springboot.extend;

public class Father {
    private String name;
    public String publicName;
    public String publicFatherName;

    public Father(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void fatherMethod(){
        System.out.println("this is fatherMethod");
    }
}
