package dxh.leetcode;
/*给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5*/

//占用太多的空间
public class T4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {1,2,3,4,5,6};
//		int[] num = getNums(nums, 2, 2);
//		for(int n : num) {
//			System.err.println(n);
//		}
//		
		int[] nums1 = {};
		int[] nums2 = {-3,-2,-1,1,5};
//		System.err.println(getSum(nums1));
		System.out.println(findMedianSortedArrays(nums1, nums2));
	
		


	}
	
	//具体思路：利用二分法，每次删除前k/2个数字，知道k=1，然后比较一下nums1和nums2数组中的最小值即可
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		//sumNum为数组nums1和nums2的总个数和
		int sumNum = nums1.length + nums2.length;
		
		int isOdd = 0;        //用于判断总个数是奇数还是偶数，若是奇数，则中位数只有一个；若是偶数，则中位数是两个的均值
		double avgNum;
		int k;                //转换成找到第k小的值
		if(sumNum % 2 == 1) {  //根据数组的长度确定k的初始值
			k = sumNum / 2 + 1; //奇数  数组的中位数为总数/2 + 1
			isOdd = 1;
		}else {
			k = sumNum / 2;
			isOdd = 0;
		}
		System.err.println(k);
		while(k != 1) {
			if(getSum(nums1) == 0 && getFlag(nums1) == 0) {
				nums1 = new int[0];
			}
			if(getSum(nums2) == 0 && getFlag(nums2) == 0) {
				nums2 = new int[0];
			}
			//这里分情况讨论，如果k/2比nums1的长度都大，那么只判断nums1的最后一个数字和nums2的第k/2个数即可
			if((k / 2) >= nums1.length && (k / 2) <= nums2.length) {
				if(getSum(nums1) == 0) {
					break;
				}
				//如果nums1中的数都比nums2中第k/2个数小，直接可去除nums1
				if(nums1[nums1.length - 1] < nums2[k / 2 - 1]) { 
					k = k - nums1.length;
					nums1 = getNums1(nums1);
				}else {
					nums2 = getNums(nums2, 0, k / 2);  //否则nums2数组去除0-k/2的数
					k = k - (k / 2);
				}
			}
			//如果k/2比整个nums2都大，那么只判断nums2的最后一个数字和nums1的k/2个数即可
			else if((k / 2) >= nums2.length && (k / 2) <= nums1.length) {
				if(getSum(nums2) == 0) {
					break;
				}
				if(nums2[nums2.length - 1] < nums1[k / 2 - 1]) {
					k = k - nums2.length;
					nums2 = getNums1(nums2);
				}else {
					nums1 = getNums(nums1, 0, k / 2); //
					k = k - (k / 2);
				}
			}
			//如果nums1和nums2中个数都大于k/2，那么直接判断nums1[k/2]和nums2[k/2]即可
			else {
				if(nums1[k / 2 - 1] <= nums2[k / 2 - 1]) {
					nums1 = getNums(nums1, 0, k / 2);
				}else {
					nums2 = getNums(nums2, 0, k / 2);
				}
				k = k - (k / 2);
			}
		}

		//根据奇偶来判断中位数的个数是2个还是1个
		if(isOdd == 1) {  //nums1和nums2数组之和的长度为奇数
			if(getSum(nums1) == 0) {
				avgNum = nums2[k - 1];
			}else if(getSum(nums2) == 0) {
				avgNum = nums1[k - 1];
			}else {
				if(nums1[k - 1] < nums2[k - 1]) {
					avgNum = nums1[k - 1];
				}else {
					avgNum = nums2[k - 1];
				}
			}
		}else {
			if(getSum(nums1) == 0) {
				avgNum = (nums2[k - 1] + nums2[k]) / 2.0;
			}else if(getSum(nums2) == 0) {
				avgNum = (nums1[k - 1] + nums1[k]) / 2.0;
			}else {
				 //对于偶数这边的计算要比较当心，会出现几种情况：
                //1、nums1[k-1]和nums1[k]都小于nums2[k-1]，那么就取nums1[k-1]和nums1[k]的平均即可
                //2、nums2[k-1]和nums2[k]都小于nums1[k-1]，那么就取nums2[k-1]和nums2[k]的平均即可
                //3、nums1[k-1]和nums2[k-1]是相对nums1[k-1]、nums1[k]、nums2[k-1]、nums2[k]这4个数字中最小的2个，
				//那么取nums1[k-1]和nums2[k-1]的平均即可
				if(nums1[k - 1] < nums2[k - 1]) {
					if(nums1.length - 1 >= k) {
						if(nums1[k] < nums2[k - 1]) {
							avgNum = (nums1[k - 1] + nums1[k]) / 2.0;
						}else {
							avgNum = (nums1[k - 1] + nums2[k - 1]) / 2.0;
						}
					}else {
						avgNum = (nums1[k - 1] + nums2[k - 1]) / 2.0;
					}
				}else {
					if(nums2.length - 1 >= k) {
						if(nums1[k - 1] < nums2[k]) {
							avgNum = (nums1[k - 1] + nums2[k - 1]) / 2.0;
						}else {
							avgNum = (nums2[k - 1] + nums2[k]) / 2.0;
						}
					}else {
						avgNum = (nums1[k - 1] + nums2[k - 1]) / 2.0;
					}
				}
			}
		}
		
		
		return avgNum;
	}
	
	//删除从begin开始的count个元素
	public static int[] getNums(int[] nums, int begin, int count) {
		int[] num = new int[nums.length - count];
		for(int i = 0; i < begin; i++) {
			num[i] = nums[i];
		}
		for(int j = begin + count; j < nums.length; j++) {
			num[j - count] = nums[j];
		}
		
		return num;
	}
	
	//将int数组内数据都赋值为0
	public static int[] getNums1(int[] nums) {
		int[] num = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			num[i] = 0;
		}
		return num;
	}
	
	//求数组的和
	public static int getSum(int[] nums) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}

	//分析数组是否全为0
	public static int getFlag(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				return 1;
			}
		}
		return 0;
	}
}
