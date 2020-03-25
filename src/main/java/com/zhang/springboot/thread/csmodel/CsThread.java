package com.zhang.springboot.thread.csmodel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CsThread {

  public static void main(String[] args) {
    int i = 9;
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        //System.out.println(i+1);
        System.out.println("测试线程池");
      }
    };
    cachedThreadPool.submit(runnable);
    i++;


  }

}
