package com.zhang.springboot.thread.threadLocal;

import com.zhang.springboot.utils.RSAUtil;

public class ThreadTest {
  private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

  public static void main(String[] args) {
//    Thread threadStart = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        threadLocal.set("你好");
//        String str = threadLocal.get();
//        System.out.println(str);
//      }
//    });
//    threadStart.start();
//    Thread threadStartTwo = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        threadLocal.set("你不好");
//        String str = threadLocal.get();
//        System.out.println(str);
//      }
//    });
//    threadStartTwo.start();

    Thread thread = new Thread(){
      @Override
      public void run(){
        System.out.println("开启端口");
        System.out.println("一直监听");
        System.out.println("直到有连接，创建新线程");
        Thread threadNew = new Thread(){
          public void run(){
            System.out.println("doing");
          }
        };
      }
    };
    thread.start();
  }
}
