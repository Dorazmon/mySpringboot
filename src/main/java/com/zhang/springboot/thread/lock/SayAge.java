package com.zhang.springboot.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SayAge {
  private Lock lock;
  private Condition condition;

  public void setLock(Lock lock) {
    this.lock = lock;
  }

  public void setCondition(Condition condition){
    this.condition = condition;
  }

  public void sayAge(){
    try {
      lock.lock();
      System.out.println("say age");
      SayHi.counterAdd();
      condition.signalAll();
    } finally {
      lock.unlock();
    }
  }

}
