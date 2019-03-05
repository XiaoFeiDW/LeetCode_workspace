package dxh.leetcode;
/*����������СΪ m �� n ���������� nums1 �� nums2��

�����ҳ������������������λ��������Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(log(m + n))��

����Լ��� nums1 �� nums2 ����ͬʱΪ�ա�

ʾ�� 1:

nums1 = [1, 3]
nums2 = [2]

����λ���� 2.0
ʾ�� 2:

nums1 = [1, 2]
nums2 = [3, 4]

����λ���� (2 + 3)/2 = 2.5*/

//ռ��̫��Ŀռ�
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
	
	//����˼·�����ö��ַ���ÿ��ɾ��ǰk/2�����֣�֪��k=1��Ȼ��Ƚ�һ��nums1��nums2�����е���Сֵ����
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		//sumNumΪ����nums1��nums2���ܸ�����
		int sumNum = nums1.length + nums2.length;
		
		int isOdd = 0;        //�����ж��ܸ�������������ż������������������λ��ֻ��һ��������ż��������λ���������ľ�ֵ
		double avgNum;
		int k;                //ת�����ҵ���kС��ֵ
		if(sumNum % 2 == 1) {  //��������ĳ���ȷ��k�ĳ�ʼֵ
			k = sumNum / 2 + 1; //����  �������λ��Ϊ����/2 + 1
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
			//�����������ۣ����k/2��nums1�ĳ��ȶ�����ôֻ�ж�nums1�����һ�����ֺ�nums2�ĵ�k/2��������
			if((k / 2) >= nums1.length && (k / 2) <= nums2.length) {
				if(getSum(nums1) == 0) {
					break;
				}
				//���nums1�е�������nums2�е�k/2����С��ֱ�ӿ�ȥ��nums1
				if(nums1[nums1.length - 1] < nums2[k / 2 - 1]) { 
					k = k - nums1.length;
					nums1 = getNums1(nums1);
				}else {
					nums2 = getNums(nums2, 0, k / 2);  //����nums2����ȥ��0-k/2����
					k = k - (k / 2);
				}
			}
			//���k/2������nums2������ôֻ�ж�nums2�����һ�����ֺ�nums1��k/2��������
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
			//���nums1��nums2�и���������k/2����ôֱ���ж�nums1[k/2]��nums2[k/2]����
			else {
				if(nums1[k / 2 - 1] <= nums2[k / 2 - 1]) {
					nums1 = getNums(nums1, 0, k / 2);
				}else {
					nums2 = getNums(nums2, 0, k / 2);
				}
				k = k - (k / 2);
			}
		}

		//������ż���ж���λ���ĸ�����2������1��
		if(isOdd == 1) {  //nums1��nums2����֮�͵ĳ���Ϊ����
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
				 //����ż����ߵļ���Ҫ�Ƚϵ��ģ�����ּ��������
                //1��nums1[k-1]��nums1[k]��С��nums2[k-1]����ô��ȡnums1[k-1]��nums1[k]��ƽ������
                //2��nums2[k-1]��nums2[k]��С��nums1[k-1]����ô��ȡnums2[k-1]��nums2[k]��ƽ������
                //3��nums1[k-1]��nums2[k-1]�����nums1[k-1]��nums1[k]��nums2[k-1]��nums2[k]��4����������С��2����
				//��ôȡnums1[k-1]��nums2[k-1]��ƽ������
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
	
	//ɾ����begin��ʼ��count��Ԫ��
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
	
	//��int���������ݶ���ֵΪ0
	public static int[] getNums1(int[] nums) {
		int[] num = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			num[i] = 0;
		}
		return num;
	}
	
	//������ĺ�
	public static int getSum(int[] nums) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}

	//���������Ƿ�ȫΪ0
	public static int getFlag(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				return 1;
			}
		}
		return 0;
	}
}
