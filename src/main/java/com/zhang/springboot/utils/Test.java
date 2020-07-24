package com.zhang.springboot.utils;

public class Test {
    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
//        for(int i =0;i<100000;i++){
//            System.out.println(i);
//        }

        for(int j =0;j<100000;j++){
            System.out.println(j);
        }
        double end = (double)(System.currentTimeMillis()-timeStart)/1000;
        System.out.println(end+"s");
    }
}
