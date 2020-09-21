package com.zhang.springboot.reflect;

public class ClassPathTest {
    public static void main(String[] args) {
        //获得类加载器
        System.out.println(ClassPathTest.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader().getParent());
        System.out.println(Thread.currentThread().getContextClassLoader().getParent().getParent());
        System.out.println(Thread.currentThread().getContextClassLoader().getParent().getParent().getParent());
        //测试类路径
        //String cp = Thread.currentThread().getContextClassLoader().
    }
}
