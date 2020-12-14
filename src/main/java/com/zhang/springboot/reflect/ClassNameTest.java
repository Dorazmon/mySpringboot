package com.zhang.springboot.reflect;

import com.zhang.springboot.collection.BillsNums;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassNameTest {
    public static void main(String[] args) throws IOException {
//        BillsNums billsNums = new BillsNums();
//        System.out.println(billsNums.getClass().toString());
//        Integer i = 3;
//        test(i);
//        File file = new File();
        //InputStream is =
        //File file = new File(is);
        System.out.println(ClassNameTest.class.getResource("/"));
        JarFile jarFile = new JarFile("G:\\IdeaPj\\myPJ\\mySpringboot\\src\\main\\resources\\taobao.jar");
        JarEntry entry = jarFile.getJarEntry("com/taobao/api/ApiException.class");
        InputStream is = jarFile.getInputStream(entry);
        System.out.println(is);
    }
    public static void test(int i){
        System.out.println(i);
    }
}
