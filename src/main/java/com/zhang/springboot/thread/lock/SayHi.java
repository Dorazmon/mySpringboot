package com.zhang.springboot.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SayHi {
  private static int counter = 1;
  private Lock lock;
  private Condition condition;

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

  public void sayHi(){
    try {
      lock.lock();
      while(SayHi.getCounter() != 2){
        condition.signalAll();
        condition.await();
      }
      System.out.println("say hi");
      SayHi.counterAdd();
      condition.signalAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
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
        sayHi.sayHi();
      }
    });

    Thread threadN = new Thread(new Runnable() {
      @Override
      public void run() {
        SayName sayName = new SayName();
        sayName.setLock(lock);
        sayName.setCondition(condition);
        sayName.sayName();
      }
    });

    Thread threadA = new Thread(new Runnable() {
      @Override
      public void run() {
        SayAge sayAge = new SayAge();
        sayAge.setLock(lock);
        sayAge.setCondition(condition);
        sayAge.sayAge();
      }
    });

    threadS.start();
    threadN.start();
    threadA.start();
  }

}
