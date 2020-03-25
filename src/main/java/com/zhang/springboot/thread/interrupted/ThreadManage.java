package com.zhang.springboot.thread.interrupted;

import java.util.HashMap;
import java.util.Map;

public class ThreadManage {
  private static Map map = new HashMap<String,Thread>();

  public static void main(String[] args) {
    Thread threadone = new Thread(new Runnable() {
      @Override
      public void run() {
          while(true&&!Thread.currentThread().isInterrupted()){
            System.out.println("跑跑跑");
          }
        System.out.println(Thread.currentThread().isInterrupted()+"线程中断");
      }
    });
    map.put("thread1",threadone);
    threadone.start();

    Thread threadtwo = new Thread(new Runnable() {
      @Override
      public void run() {
        Thread thread = (Thread) map.get("thread1");
        thread.interrupt();
      }
    });
    threadtwo.start();



  }

}
