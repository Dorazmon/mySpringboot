package com.zhang.springboot.thread;

public class DebugTest {

  public static void main(String[] args) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("开始");
        System.out.println("测试");
      }
    };
    Thread test = new Thread(runnable);
    Thread test2 = new Thread(runnable);
    test2.start();
    test.start();
  }

}
