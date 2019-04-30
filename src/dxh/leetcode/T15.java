package dxh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]*/

public class T15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums= {-1, 0, 1, 2, -1, -4};
//		List<List<Integer>> listSum = threeSum(nums);
//		System.out.println(threeSum(nums));
		List<Integer> list = Arrays.asList(1, 2, 3);
		list.forEach(System.out :: println);
//		System.err.println(list);
	
	}
	
	public static List<List<Integer>> threeSum(int[] nums){
		Arrays.sort(nums);   //首先给数组进行排序
		List<List<Integer>> listSum = new ArrayList<>();
//		List<Integer> listNum = new ArrayList<>();
		int len = nums.length;
		for(int i = 0; i < len - 2; i++) {
			if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) { //跳过重复的值
				int j = i + 1, k = len - 1, sum = 0 - nums[i];
				while(j < k) {
					if(nums[j] + nums[k] == sum) {
						listSum.add(Arrays.asList(nums[i], nums[j], nums[k]));
						
						while(j < k && nums[j] == nums[j + 1]) {
							j++;
						}
						while(j < k && nums[k] == nums[k - 1]) {
							k--;
						}
						j++;
						k--;
					}else if(nums[j] + nums[k] < sum) {
						while(j < k && nums[j] == nums[j + 1]) {
							j++;
						}
						j++;
					}else {
						while(j < k && nums[k] == nums[k - 1]) {
							k--;
						}
						k--;
					}
				}
			}
		}
		
		return listSum;
	}

}
