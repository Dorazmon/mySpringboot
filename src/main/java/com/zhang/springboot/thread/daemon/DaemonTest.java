package com.zhang.springboot.thread.daemon;

public class DaemonTest {
    public static void main(String[] args) {
        Thread thread = new Thread(){
           public void run(){
               while (true){
                   System.out.println("shouhuxiancheng");
               }
           }
        };
        thread.setDaemon(true);
        thread.start();
        Thread threadNo = new Thread(){
            public void run(){
                while (true){
                    System.out.println("feishouhu");
                }
            }
        };
        threadNo.start();
    }

}
