package com.zhang.springboot.collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionStreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("z");
        list.add("h");
        list.add("a");
        List<String> newList = new ArrayList<String>();
        list.stream().forEach((t)->{
            newList.add(t);
            System.out.println(t);
        });

    }
}
