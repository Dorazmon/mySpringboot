package com.zhang.springboot.collection;

public class BillsNums implements TestBillsNums{

	private String clothingid;
	private String name;
	private int nums;
	private double sums;

	public BillsNums() {
		System.out.println("g");

	}

	public BillsNums(String clothingid, String name, int nums, double sums) {
		this.clothingid = clothingid;
		this.name = name;
		this.nums = nums;
		this.sums = sums;
	}

	/**
	 * 商品编号
	 * 
	 * @return
	 */
	public String getClothingid() {
		return clothingid;
	}

	/**
	 * 商品编号
	 * 
	 * @return
	 */
	public void setClothingid(String clothingid) {
		this.clothingid = clothingid;
	}

	/**
	 * 名称
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 数量
	 * 
	 * @return
	 */
	public int getNums() {
		return nums;
	}

	/**
	 * 数量
	 * 
	 * @param nums
	 */
	public void setNums(int nums) {
		this.nums = nums;
	}

	/**
	 * 金额
	 * 
	 * @return
	 */
	public double getSums() {
		return sums;
	}

	public void setSums(double sums) {
		this.sums = sums;
	}

	@Override
	public void test() {
		System.out.println("hahah");
	}

	public static void main(String[] args) {
		BillsNums billsNums = new BillsNums();
	}
}
