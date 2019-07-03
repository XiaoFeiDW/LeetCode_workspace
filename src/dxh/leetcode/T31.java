package dxh.leetcode;
/*
 * ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�

�����������һ����������У��������������г���С�����У����������У���

����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣

������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С�
1,2,3 �� 1,3,2
3,2,1 �� 1,2,3
1,1,5 �� 1,5,1

*��˼�����ҵ���Ŀǰ��ֵ�������һ����*/
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
