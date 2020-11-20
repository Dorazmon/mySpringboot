package com.zhang.springboot.reflect;

import com.zhang.springboot.collection.BillsNums;

public class ClassNameTest {
    public static void main(String[] args) {
//        BillsNums billsNums = new BillsNums();
//        System.out.println(billsNums.getClass().toString());
        Integer i = 3;
        test(i);
    }
    public static void test(int i){
        System.out.println(i);
    }
}
