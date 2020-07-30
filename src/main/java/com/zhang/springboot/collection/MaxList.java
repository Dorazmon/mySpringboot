package com.zhang.springboot.collection;

import java.util.ArrayList;
import java.util.List;

public class MaxList {
    public static void main(String[] args) {
        List<BillsNums> list = null;
        try {
            list = new ArrayList<BillsNums>();
            while (true) {
                BillsNums billsNums = new BillsNums();
                billsNums.setName("hhh");
                billsNums.setNums(00);
                list.add(billsNums);
               // System.out.println(list.size());
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(list.size());
        }

    }
}
