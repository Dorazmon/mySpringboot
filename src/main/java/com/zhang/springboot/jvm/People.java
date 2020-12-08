package com.zhang.springboot.jvm;

public class People {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int addAge(int age){
        return age+this.age;
    }

    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run(){
                People people = new People();
                int newAge = people.addAge(8);
                System.out.println(newAge);
                System.out.println("测试");
            }
        };
        t.start();
    }
}
