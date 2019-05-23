package dxh.leetcode;

public class T26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {0, 1, 1, 2, 2, 3, 3, 4};
		System.err.println(removeDuplicates(nums));
	}
	
	public static int removeDuplicates(int[] nums) {
		
		int len = 1;
		if(nums == null) {
			return 0;
		}
		int j = 1;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] != nums[i - 1]) {
				nums[j++] = nums[i];
				len++;
			}
		}
		
		return len;
	}

}
