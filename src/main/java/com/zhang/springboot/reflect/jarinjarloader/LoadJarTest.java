package com.zhang.springboot.reflect.jarinjarloader;

import com.taobao.api.ApiException;
import com.zhang.springboot.collection.BillsNums;

import java.util.ArrayList;

public class LoadJarTest {
    public static void main(String[] args) {
        System.out.println("test");
        System.out.println(new ApiException());
        System.out.println(new BillsNums());
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(new ArrayList<>());
    }
}
