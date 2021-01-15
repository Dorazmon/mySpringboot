package com.zhang.springboot.thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DebugTest {

  public static void main(String[] args) {
//    Runnable runnable = new Runnable() {
//      @Override
//      public void run() {
//        System.out.println("开始");
//        System.out.println("测试");
//      }
//    };
//    Thread test = new Thread(runnable);
//    Thread test2 = new Thread(runnable);
//    test2.start();
//    test.start();
//    AtomicBoolean locked = new AtomicBoolean(false);
//    System.out.println(locked.compareAndSet(false, true));
//    System.out.println(locked.compareAndSet(false, false));
    AtomicInteger atomicInteger = new AtomicInteger();
    System.out.println(atomicInteger.compareAndSet(0,2));
    System.out.println(atomicInteger.compareAndSet(1,1));


  }

}
