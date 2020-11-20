package com.zhang.springboot.thread.demo;

public class ThreadTimer implements Runnable{


  @Override
  public void run() {
      try {
          Thread.sleep(1000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }

    public static void main(String[] args) {
        
    }
}
