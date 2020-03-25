package com.zhang.springboot.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List比较函数
 * 这里标注所在部门+姓名
 * @author qdy
 *
 */
public class ListCompare {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1.add("苹果手机");
		list1.add("华为手机");
		list1.add("电脑");
		list1.add("苹果");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("苹果手机");
		list2.add("华为手机");
		list2.add("电脑");
		list2.add("苹果");	
		
		
		boolean sure=find(list1,"苹果");
        System.out.println("sure:"+sure);
	}
	
	
	public static boolean find(List<String> list,String str){
		//TODO 在这里实现:在list查找str是否存在，存在返回true,不存在返回false
		if(list.isEmpty()||list==null||str==null||"".equals(str)){
			return false;
		}
		for(String strList:list){
		   if(str.equals(strList)){
          return true;
			 }
		}
		return false;
	}

	/**
	 * 返回集合差异部分
	 * 比较两个集合，把差异部分返回
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<String> differenceList(List<String> list1,List<String> list2 ){
		//TODO 在这里实现代码：返回两个集合差异部分
		List<String> diff = new ArrayList<String>();
		for(String str:list1){
        for (String str2:list2){
        	if(!str.equals(str2)){
						diff.add(str);
					}
				}
		}
		return diff;
	}
	
	/**
	 * 返回集合相同部分
	 * 比较两个集合，返回相同部分
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<String> equalList(List<String> list1,List<String> list2 ){
		//TODO 在这里实现代码：返回两个集合返回相同部分
		List<String> diff = new ArrayList<String>();
		for(String str:list1){
			for (String str2:list2){
				if(str.equals(str2)){
					diff.add(str);
				}
			}
		}
		return diff;
	}
}
