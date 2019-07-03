package dxh.leetcode;
/*
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*意思就是找到比目前数值更大的下一个数*/
public class T31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {5, 4, 3, 2, 1};
		nextPermutation(nums);
		for(int num : nums) {
			System.out.print(num);
		}
	}
	
	public static void nextPermutation(int[] nums) {
		
		int len = nums.length;
		
		int i = len - 2;
		while(i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		
		int j = len - 1;
		if(i >= 0) {
			while(j >= 0 && nums[i] >= nums[j]) {
				j--;
			}
			swap(nums, i, j);
		}
		converse(nums, i + 1, len - 1);
	}
	
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void converse(int[] nums, int start, int end) {

		while(end > start) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

}
