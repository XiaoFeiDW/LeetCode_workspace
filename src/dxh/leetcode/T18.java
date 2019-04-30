package dxh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[吃
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]*/
public class T18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		List<List<Integer>> four = fourSum(nums, target);
		for(List l : four) {
			System.out.println(Collections.EMPTY_LIST);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<List<Integer>> fourSum(int[] nums, int target){
		HashSet<List<Integer>> four = new HashSet<>();
		Arrays.sort(nums);
		if(nums.length < 4 || nums[0] > 0) {
			return Collections.EMPTY_LIST;
		}
		
		int len = nums.length;
		
		for(int i = 0; i < len - 3; i++) {
			for(int j = i + 1; j < len - 2; j++) {
				int m = j + 1, n = len - 1;
				while(m < n) {
					if(nums[i] + nums[j] + nums[m] + nums[n] == target) {
						four.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
						while(m < len - 1 && nums[m] == nums[m - 1]) m++;
						while(n > j + 1 && nums[n] == nums[n - 1]) n--;
						m++;
						n--;
					}else if(nums[i] + nums[j] + nums[m] + nums[n] < target) {
						m++;
					}else {
						n--;
					}		
				}
			}
		}
		
		return new ArrayList(four);
	}

}
