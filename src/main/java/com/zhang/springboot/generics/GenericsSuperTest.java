package com.zhang.springboot.generics;

import com.zhang.springboot.collection.BillsNums;
import com.zhang.springboot.collection.TestBillsNums;

import java.util.ArrayList;
import java.util.List;

public class GenericsSuperTest {
    public static List<? super BillsNums> test(){
          List<? super BillsNums> test = new ArrayList<BillsNums>();
          List<? extends TestBillsNums>  testBillsNums = new ArrayList<TestBillsNums>();
          return test;
    }

    public static void main(String[] args) {
         //List<BillsNums> list = test();
    }
}
