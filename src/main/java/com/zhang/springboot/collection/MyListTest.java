package com.zhang.springboot.collection;

import java.util.ArrayList;
import java.util.List;

public class MyListTest {
    public static void main(String[] args) {
        List<BillsNums> lists = new ArrayList<>();
        BillsNums billsNums = new BillsNums();
        lists.add(billsNums);
        lists.clear();
    }
}
