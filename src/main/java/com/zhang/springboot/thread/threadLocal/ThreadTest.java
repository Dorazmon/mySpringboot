package com.zhang.springboot.thread.threadLocal;

public class ThreadTest {
  private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

  public static void main(String[] args) {
    Thread threadStart = new Thread(new Runnable() {
      @Override
      public void run() {
        threadLocal.set("你好");
        String str = threadLocal.get();
        System.out.println(str);
      }
    });
    threadStart.start();
    Thread threadStartTwo = new Thread(new Runnable() {
      @Override
      public void run() {
        threadLocal.set("你不好");
        String str = threadLocal.get();
        System.out.println(str);
      }
    });
    threadStartTwo.start();
  }

}
