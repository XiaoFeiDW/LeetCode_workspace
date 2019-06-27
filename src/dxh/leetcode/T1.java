package dxh.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * T1:
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

   你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
  
  例：
   给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
 * */


public class T1 {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] count = twoSum(nums, target);
		for(int num : count) {
			System.out.print(num + " ");
		}
		
//		ListNode l = new ListNode(0);
////		System.out.println(l.val);
//		l.val = 2;
//		System.err.println(l.val);
	}
	
	/*//自己书写， 暴力法解决 ，时间复杂度：O(n^2)   空间复杂度O(1)
	public static int[] twoSum(int[] nums, int target) {
		int[] count = new int[2];
		int len = nums.length;
		for(int i = 0; i < len; i++) {
			for(int j = i + 1; j < len; j++) {
				if(target == nums[i] + nums[j]) {
					count[0] = i;
					count[1] = j;
					break;
				}
			}
		}
		
		return count;
	}*/
	
	/*两遍哈希表：为了对运行时间复杂度进行优化，我们需要一种更有效的方法来检查数组中是否存在目标元素；
	 * 如果存在，我们需要找出它的索引。保持数组中的每个元素与其索引相互对应的最好方法就是哈希表
	 * 
	 * 通过以空间换取速度的方式，我们可以将查找时间从O(n)降为O(1)哈希表正式为此目的而构建的，它支持以近似恒定的时间
	 * 进行快速查找。
	 * 时间复杂度：O(n)   空间复杂度：O(n)
	 * */
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            numsMap.put(nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++){
            int num = target - nums[i];
            if(numsMap.containsKey(num) && numsMap.get(num) != i){
                return new int[]{i, numsMap.get(num)};
            }
        }
	    return null ;
		
	}
	
	//一遍哈希表
	//时间复杂度O(n)  空间复杂度O(n)
	public static int[] twoSum1(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			int com = target - nums[i];
			if(map.containsKey(com)) {
				return new int[] {map.get(com), i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
}
