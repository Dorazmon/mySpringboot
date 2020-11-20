package com.zhang.springboot.extend;

public class Child extends Father{
    private String name;
    public String publicName = "this Child.publicName";

    public Child(String name) {
        super("father");
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        getName();
        this.name = name;
    }

    /**
     * 获得父类的名字
     */
    public void getFatherPublicName(){
        System.out.println(super.publicName);
    }

    public void getSuper(){
        System.out.println(this.toString());
        System.out.println(super.toString());
    }

    public static void main(String[] args) {
        Child child = new Child("child");
        child.getSuper();
//        child.fatherMethod();
//        System.out.println(child.publicName);
//        System.out.println(child.publicName);
//        System.out.println(child.publicFatherName);
    }
}
