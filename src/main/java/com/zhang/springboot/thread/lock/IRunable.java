package com.zhang.springboot.thread.lock;

public interface IRunable {

  /**
   * 要做的事情
   */
  public void handle();

  /**
   * 设置执行顺序---标识
   */
  public void setOrder(int order);
  /**
   * 总顺序
   */
  public void setOrderCount(int orderCount);
}
