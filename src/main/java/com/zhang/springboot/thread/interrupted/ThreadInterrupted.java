package com.zhang.springboot.thread.interrupted;

public class ThreadInterrupted {

  public static void main(String[] args) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          int i = 6;
          if(i==10){
            throw  new InterruptedException();
          }
          System.out.println("hhh");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }
    });
    thread.start();

  }

}
