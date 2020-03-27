package com.zhang.springboot.thread.interrupted;

public class ThreadDemo {

  public static void main(String[] args) {
    //System.out.println(Thread.currentThread().isInterrupted());
    //Thread.currentThread().interrupt();
    //System.out.println(Thread.currentThread().isInterrupted());
    System.out.println(Thread.interrupted());
    System.out.println("h"+Thread.currentThread().isInterrupted());
    Thread.currentThread().interrupt();
    //System.out.println(Thread.currentThread().interrupted());
    System.out.println("h"+Thread.currentThread().isInterrupted());
    //System.out.println(Thread.currentThread().interrupted());
    System.out.println("h"+Thread.currentThread().isInterrupted());
  }

}
