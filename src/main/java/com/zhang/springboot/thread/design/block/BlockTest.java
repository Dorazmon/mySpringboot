package com.zhang.springboot.thread.design.block;

public class BlockTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        Thread.currentThread().join();
        //阻塞线程
        Thread.currentThread().sleep(100);
        Thread thread = new Thread(){
            public void run(){
                System.out.println("thread to do");
            }
        };
        thread.start();
        System.out.println("final");


    }
}
