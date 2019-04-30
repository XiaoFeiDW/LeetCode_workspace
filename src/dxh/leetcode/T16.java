package dxh.leetcode;

import java.util.Arrays;

/*给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).*/

public class T16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,4,8,16,32,64,128};
		int target = 82;
		int num = threeSumClosest(nums, target);
		System.err.println(num);
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);   //先对数组进行升序处理
		int sum = nums[0] + nums[1] + nums[2];
		int len = nums.length;
		for(int i = 0; i < len - 2; i++) {
			int j = i + 1, k = len - 1;
			while(j < k) {
				int sum1 = nums[i] + nums[j] + nums[k];
				
				if(Math.abs(sum1 - target) < Math.abs(sum - target)) {
					sum = sum1;
				}
				if(sum1 > target) {
					k--;
				}else if(sum1 < target){
					j++;
				}else {
					return target;
				}
			}
			
		}
		return sum;
	}

}
