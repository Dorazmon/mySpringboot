package com.zhang.springboot.thread.interrupted;

import java.util.concurrent.CountDownLatch;

public class ThreadCountDownLatch {

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(100);
    Thread threadOne = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("hehe");
        int i = 100;
        for(int j=0;j<100;j++){
          System.out.println(i--);
          countDownLatch.countDown();
        }
      }
    });
    threadOne.start();
    countDownLatch.await();
    System.out.println("停止了");
  }

}
