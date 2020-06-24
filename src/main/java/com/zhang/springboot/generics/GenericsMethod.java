package com.zhang.springboot.generics;

import com.zhang.springboot.collection.BillsNums;
import com.zhang.springboot.ioc.People;

import java.util.ArrayList;
import java.util.List;

public class GenericsMethod {
    public static <T>  T test(List<T> t){
          return  t.get(0);
    }

    public static <T>  T test2(T t){
        return  t;
    }

    public static void main(String[] args) {
        People people = new People();
        BillsNums billsNums = new BillsNums();
        List<BillsNums> billsNumss = new ArrayList<BillsNums>();
        GenericsMethod.<BillsNums>test(billsNumss);
        //GenericsMethod.<People>test(billsNums);
    }
}
