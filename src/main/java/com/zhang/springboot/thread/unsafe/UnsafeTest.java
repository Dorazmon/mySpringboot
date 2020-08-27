package com.zhang.springboot.thread.unsafe;

import sun.misc.Unsafe;

import java.util.concurrent.locks.LockSupport;

public class UnsafeTest {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            public void run(){
                while(true){
                    System.out.println("safeTest");
                    LockSupport.park();
                }
            }
        };
        thread.start();
        LockSupport.unpark(thread);
    }
}
