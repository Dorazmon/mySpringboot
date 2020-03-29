package com.zhang.springboot.thread.lock;

import java.util.List;

public interface ISysnRunable {

  /**
   * 封装运行
   * @param iRunables
   */
 public void doIsysnRunable(List<IRunable> iRunables);
}