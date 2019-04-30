package dxh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*����һ������ n ������������ nums���ж� nums ���Ƿ��������Ԫ�� a��b��c ��ʹ�� a + b + c = 0 ���ҳ��������������Ҳ��ظ�����Ԫ�顣

ע�⣺���в����԰����ظ�����Ԫ�顣

����, �������� nums = [-1, 0, 1, 2, -1, -4]��

����Ҫ�����Ԫ�鼯��Ϊ��
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
		Arrays.sort(nums);   //���ȸ������������
		List<List<Integer>> listSum = new ArrayList<>();
//		List<Integer> listNum = new ArrayList<>();
		int len = nums.length;
		for(int i = 0; i < len - 2; i++) {
			if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) { //�����ظ���ֵ
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
