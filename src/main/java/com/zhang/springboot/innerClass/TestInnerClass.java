package com.zhang.springboot.innerClass;

public class TestInnerClass {
  static {

  }

  {

  }
  private class Car{
    private String name;
    private String brand;


    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getBrand() {
      return brand;
    }

    public void setBrand(String brand) {
      this.brand = brand;
    }
  }

  public class Cup{
    private String name;
    private String brand;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getBrand() {
      return brand;
    }

    public void setBrand(String brand) {
      this.brand = brand;
    }
  }

}
