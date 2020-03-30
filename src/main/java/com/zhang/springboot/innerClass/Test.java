package com.zhang.springboot.innerClass;

import com.zhang.springboot.innerClass.TestInnerClass.Cup;

public class Test {

  public static void main(String[] args) {
    TestInnerClass testInnerClass = new TestInnerClass();
    Cup cup = testInnerClass.new Cup();
  }

}
