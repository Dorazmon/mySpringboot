package com.zhang.springboot.collection;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * List合并函数
 * 这里标注所在部门+姓名
 * @author qdy
 *
 */
public class ListMerge {

	public static void main(String[] args) {

		List<BillsNums> list1 = new ArrayList<BillsNums>();

		BillsNums nums=new BillsNums();
		nums.setClothingid("1001");
		nums.setName("苹果33");
		nums.setNums(2);
		nums.setSums(100);
		list1.add(nums);

		BillsNums nums1=new BillsNums();
		nums1.setClothingid("1001");
		nums1.setName("苹果");
		nums1.setNums(3);
		nums1.setSums(100);
		list1.add(nums1);

		BillsNums nums3=new BillsNums();
		nums3.setClothingid("1003");
		nums3.setName("苹果");
		nums3.setNums(3);
		nums3.setSums(100);
		list1.add(nums3);

		BillsNums nums4=new BillsNums();
		nums4.setClothingid("1003");
		nums4.setName("苹果");
		nums4.setNums(3);
		nums4.setSums(100);
		list1.add(nums4);
		
		List<BillsNums> list2=merge(list1);
        System.out.println("list1:"+JSON.toJSONString(list2,true));
	}

	/**
	 * 按clothingid进行合并
	 * nums，sums相加
	 * 返回合并后的集合
	 * @param list
	 * @return
	 */
	public static List<BillsNums> merge(List<BillsNums> list){
		//TODO 在这里实现代码：将 list 中 clothingid 相等的对象进行合并，name任意取，nums相加；sums相加
		List<BillsNums> listMerge = new ArrayList<BillsNums>();
		//分组
		Map<String,List<BillsNums>> map = new HashMap<String,List<BillsNums>>();
		for(BillsNums billsNum:list){
			if(map.containsKey(billsNum.getClothingid())){
				map.get(billsNum.getClothingid()).add(billsNum);
			}else{
				List<BillsNums> billsNumList = new ArrayList<BillsNums>();
				billsNumList.add(billsNum);
        map.put(billsNum.getClothingid(),billsNumList);
			}
		}
		//遍历map
		for(Map.Entry<String,List<BillsNums>> entry:map.entrySet()){
			List<BillsNums> billsNums = entry.getValue();
			BillsNums billsNum = getBillsNums(billsNums);
			listMerge.add(billsNum);
		}
//		int length = list.size();
//		for(int i=0;i<length;i++){
//			for(int j=i+1;j<length;j++){
//				BillsNums billsNumsOne = list.get(i);
//				BillsNums billsNumsTwo = list.get(j);
//				if(billsNumsOne.getClothingid().equals(billsNumsTwo.getClothingid())){
//					billsNumsOne.setNums(billsNumsOne.getNums()+billsNumsTwo.getNums());
//					billsNumsOne.setSums(billsNumsOne.getSums()+billsNumsTwo.getSums());
//					listMerge.add(billsNumsOne);
//				}
//			}
//		}

		return listMerge;
	}

	/**
	 * 累加
	 * @param billsNums
	 * @return
	 */

	public static BillsNums getBillsNums(List<BillsNums> billsNums){
		 int nums =0;
		 double sums =0;
     for(BillsNums billsNum:billsNums){
        nums = nums + billsNum.getNums();
        sums = sums +  billsNum.getSums();
		 }
     BillsNums billsNumNew = new BillsNums();
     billsNumNew.setClothingid(billsNums.get(0).getClothingid());
		 billsNumNew.setName(billsNums.get(0).getName());
		 billsNumNew.setNums(nums);
		 billsNumNew.setSums(sums);
     return billsNumNew;
	}
	
}
