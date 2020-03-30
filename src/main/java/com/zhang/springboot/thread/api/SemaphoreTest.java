package com.zhang.springboot.thread.api;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

  public static void main(String[] args) {
    final Semaphore semaphore = new Semaphore(2);
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        try {
          semaphore.acquire();
          Thread.sleep(20000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("多线程哦");
      }
    };
    Thread thread1 = new Thread(runnable);
    Thread thread2 = new Thread(runnable);
    Thread thread3 = new Thread(runnable);
    thread1.start();
    thread2.start();
    thread3.start();
  }

}
