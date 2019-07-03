package dxh.leetcode;
/*
 * 
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]

示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class T34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] m = {1, 2, 3, 5, 6, 7, 8, 9, 10, 11};
//		int[] n = searchRange(m, 8);
//		for(int num : n) {
//			System.out.println(num);
//		}
		System.err.println(getIndex(m, 5));
		
	}
	
	
	public static int[] searchRange(int[] nums, int target) {
		 int[] range = new int[2];
	        
	        int len = nums.length;
	        if(len == 0){
	            return new int[]{-1, -1};
	        }
	        
	        int index = getIndex(nums, target);
	        if(index == -1){
	            return new int[]{-1, -1};
	        }
	        
	        int rl = index, rh = len - 1;
	        while(rl <= rh){
	            int rm = (rl + rh) / 2;
	            if(target == nums[rm]){
	                rl = rm + 1;
	            }else{
	                rh = rm - 1;
	            }
	        }
	        range[1] = rh;
	        
	        int ll = 0, lh = index;
	        while(ll <= lh){
	            int lm = (ll + lh) / 2;
	            if(target == nums[lm]){
	                lh = lm - 1;
	            }else{
	                ll = lm + 1;
	            }
	        }
	        range[0] = ll;
	        
	        return range;
		
	}

	public static int getIndex(int[] nums, int target) {
		 int len = nums.length;
	        
	        int low = 0;
	        int high = len - 1;
	        int mid = 0;
	        while(high >= low){
	            mid = (high + low) / 2;
	            
	            if(target > nums[mid]){
	                low = mid + 1;
	            }else if(target < nums[mid]){
	                high = mid - 1;
	            }else {
	            	break;
	            }
	              
	        }
	        if(target == nums[mid]) {
	        	return mid;
	        }
	  
	        return -1;
	}
}
