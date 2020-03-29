package com.zhang.springboot.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SayName {

  private Lock lock;
  private Condition condition;

  public void setLock(Lock lock) {
    this.lock=lock;
  }

  public void setCondition(Condition condition) {
    this.condition=condition;
  }

  public void sayName(){
    try {
      lock.lock();
      while(SayHi.getCounter() != 3){
        condition.signalAll();
        condition.await();
      }
      System.out.println("say name");
      condition.signalAll();

    } catch (Exception e){
      e.printStackTrace();
    }finally {
      lock.unlock();
    }
  }

}
