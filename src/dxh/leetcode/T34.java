package dxh.leetcode;
/*
 * 
 * ����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�

����㷨ʱ�临�Ӷȱ����� O(log n) ����

��������в�����Ŀ��ֵ������ [-1, -1]��

ʾ�� 1:

����: nums = [5,7,7,8,8,10], target = 8
���: [3,4]

ʾ�� 2:

����: nums = [5,7,7,8,8,10], target = 6
���: [-1,-1]

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������*/

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
