package com.zhang.springboot.thread.api;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(1);
    final Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("hhh");
        //countDownLatch.countDown();
        LockSupport.park();
        System.out.println("fff");
      }
    });
    thread.start();
    //th[read.join();
   // countDownLatch.wait();
    System.out.println("aaa");
    LockSupport.unpark(thread);

  }

}
