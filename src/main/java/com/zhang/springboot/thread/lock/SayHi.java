package com.zhang.springboot.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SayHi implements IRunable{
  private static int counter = 1;
  private Lock lock;
  private Condition condition;
  private int order;
  private int orderCount;

  public static void counterAdd(){
    counter++;
  }

  public static int getCounter(){
    return counter;
  }

  public void setLock(Lock lock) {
    this.lock = lock;
  }

  public void setCondition(Condition condition){
    this.condition = condition;
  }

  public void handle(){
    try {
      lock.lock();
      //标识，判断是否到执行
      while(orderCount != order){
        condition.signalAll();
        condition.await();
      }
      System.out.println("say hi");
      order++;
      condition.signalAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  @Override
  public void setOrder(int order) {
    this.order = order;
  }

  @Override
  public void setOrderCount(int orderCount) {
    this.orderCount = orderCount;
  }

  public static void main(String[] args) {
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();
    Thread threadS = new Thread(new Runnable() {
      @Override
      public void run() {
        SayHi sayHi = new SayHi();
        sayHi.setLock(lock);
        sayHi.setCondition(condition);
        sayHi.handle();
      }
    });

    Thread threadN = new Thread(new Runnable() {
      @Override
      public void run() {
        SayName sayName = new SayName();
        sayName.setLock(lock);
        sayName.setCondition(condition);
        sayName.handle();
      }
    });

    Thread threadA = new Thread(new Runnable() {
      @Override
      public void run() {
        SayAge sayAge = new SayAge();
        sayAge.setLock(lock);
        sayAge.setCondition(condition);
        sayAge.handle();
      }
    });

    threadS.start();
    threadN.start();
    threadA.start();
  }

}
