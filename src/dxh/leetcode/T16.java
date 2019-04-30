package dxh.leetcode;

import java.util.Arrays;

/*����һ������ n ������������ nums �� һ��Ŀ��ֵ target���ҳ� nums �е�����������ʹ�����ǵĺ��� target ��ӽ���
 * �������������ĺ͡��ٶ�ÿ������ֻ����Ψһ�𰸡�

���磬�������� nums = [-1��2��1��-4], �� target = 1.

�� target ��ӽ����������ĺ�Ϊ 2. (-1 + 2 + 1 = 2).*/

public class T16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,4,8,16,32,64,128};
		int target = 82;
		int num = threeSumClosest(nums, target);
		System.err.println(num);
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);   //�ȶ��������������
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
