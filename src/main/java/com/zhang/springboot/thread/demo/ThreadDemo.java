package com.zhang.springboot.thread.demo;

public class ThreadDemo {
   private static int i;
   private static ThreadObject threadObject = new ThreadObject();

  public static ThreadObject getThreadObject() {
    return threadObject;
  }

  public static void setThreadObject(ThreadObject threadObject) {
    ThreadDemo.threadObject = threadObject;
  }

  public static int getI() {
    return i;
  }

  public static void setI(int i) {
    ThreadDemo.i = i;
  }

  public static void main(String[] args) {
    Thread threadone = new Thread(){
      @Override
      public void run() {
        ThreadObject threadObject = ThreadDemo.getThreadObject();
        System.out.println(threadObject.getAge());
        threadObject.setAge(2);
        System.out.println(threadObject.getAge());
      }
    };
    Thread threadtwo = new Thread(){
      @Override
      public void run() {
        ThreadObject threadObject = ThreadDemo.getThreadObject();
        while(true){
          System.out.println(threadObject.getAge());
        }
      }
    };
    threadtwo.start();
    threadone.start();
  }
}
