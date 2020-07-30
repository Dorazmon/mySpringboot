package com.zhang.springboot.utils;

import java.util.*;

public class DealDataCheckUtils {

    public static final Long groupNum = 5000000L;

    //分组
    public static List<DealGroupNum> groupNum(Long startNo, Long endNo){
        List<DealGroupNum> dealGroupNums = new ArrayList<DealGroupNum>();
        Long count = endNo - startNo + 1;
        //一次
        if(count<groupNum){
            DealGroupNum dealGroupNum = new DealGroupNum();
            dealGroupNum.setStartNo(startNo);
            dealGroupNum.setEndNO(endNo);
            dealGroupNums.add(dealGroupNum);
            return dealGroupNums;
        }else{
            //几次
            long time = (long) Math.ceil((double) count / groupNum);
            for(Long startTime=1L;startTime<=time;startTime++){
                if(startTime!=time){
                    //不是最后一次
                    DealGroupNum dealGroupNum = new DealGroupNum();
                    dealGroupNum.setStartNo(startNo+((startTime-1)*groupNum));
                    dealGroupNum.setEndNO(startNo+(startTime*groupNum)-1);
                    dealGroupNums.add(dealGroupNum);
                }else {
                    //最后一次
                    DealGroupNum dealGroupNum = new DealGroupNum();
                    dealGroupNum.setStartNo(startNo+((startTime-1)*groupNum));
                    dealGroupNum.setEndNO(endNo);
                    dealGroupNums.add(dealGroupNum);
                }
            }
            return dealGroupNums;
        }
    }
}
