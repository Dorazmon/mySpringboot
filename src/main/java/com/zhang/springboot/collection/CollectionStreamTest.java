package com.zhang.springboot.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionStreamTest {
    public static void main(String[] args) {
        listGroupByStream();
    }

    /**
     * 测试列表分组
     */
    public static void listGroupByStream(){
        BillsNums billsNums = new BillsNums();
        billsNums.setClothingid("1111");
        billsNums.setName("Vn");
        BillsNums billsNums1 = new BillsNums();
        billsNums1.setClothingid("1111");
        billsNums1.setName("yasuo");
        BillsNums billsNums2 = new BillsNums();
        billsNums2.setClothingid("2222");
        billsNums2.setName("cuishi");
        List<BillsNums> billsNumsList = new ArrayList<>();
        billsNumsList.add(billsNums);
        billsNumsList.add(billsNums1);
        billsNumsList.add(billsNums2);
        Map<String,List<BillsNums>> map = billsNumsList.stream().collect(Collectors.groupingBy(billsNumsTemp ->{return billsNumsTemp.getClothingid();}));
    }
}
