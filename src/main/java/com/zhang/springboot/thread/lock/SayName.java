package com.zhang.springboot.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SayName implements IRunable{

  private Lock lock;
  private Condition condition;
  private int order;
  private int orderCount;

  public void setLock(Lock lock) {
    this.lock=lock;
  }

  public void setCondition(Condition condition) {
    this.condition=condition;
  }

  public void handle(){
    try {
      lock.lock();
      while(orderCount != order){
        condition.signalAll();
        condition.await();
      }
      System.out.println("say name");
      order++;
      condition.signalAll();
    } catch (Exception e){
      e.printStackTrace();
    }finally {
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

}
