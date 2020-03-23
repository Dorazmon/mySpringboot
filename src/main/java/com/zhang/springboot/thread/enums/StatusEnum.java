package com.zhang.springboot.thread.enums;

public enum StatusEnum {
  start("开始"),stop("停止");
  private String desc;

  public String desc() {
    return desc;
  }

  private StatusEnum(String desc) {
    this.desc = desc;
  }

}
