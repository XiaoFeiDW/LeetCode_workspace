package dxh.leetcode;
/*假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1

*
*要求时间复杂度为O(log n)，所以应该使用二分查找法*/

public class T33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1};
		int target = 0;
		System.out.println(search(nums, target));
	}
	public static int search(int[] nums, int target) {
        
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        
        int high = len - 1;
        int low = 0;
        
        while(high >= low){
             int mid = (high + low) / 2;
            if(target <= nums[len - 1]){
                if(target <= nums[mid] && nums[mid] < nums[high]){
                    high = mid;
                }else{
                    low = mid;
                }
            }else{
                if(target >= nums[mid] && nums[mid] > nums[low]){
                    low = mid;
                }else{    
                    high = mid;
                }
            }
            if(target == nums[mid]){
                return mid;
            }
            else if(target == nums[high]){
                return high;
            }else if(target == nums[low]) {
            	return low;
            }
            else if(high - low <= 1) {
            	break;
            }
        }
		return -1;
    }

}
