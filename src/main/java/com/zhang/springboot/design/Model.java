package com.zhang.springboot.design;

public class Model {
  private String name;
  private int age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void getNameFirst(int y){
    int i = y;
    //调用其它对象的方法
    age=100;
    //int j = i+1;
  }
}
