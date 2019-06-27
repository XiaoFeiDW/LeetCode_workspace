package dxh.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * T1:
 * ����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������

   ����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�
  
  ����
   ���� nums = [2, 7, 11, 15], target = 9
    ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
    ���Է��� [0, 1]
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
	
	/*//�Լ���д�� ��������� ��ʱ�临�Ӷȣ�O(n^2)   �ռ临�Ӷ�O(1)
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
	
	/*�����ϣ��Ϊ�˶�����ʱ�临�ӶȽ����Ż���������Ҫһ�ָ���Ч�ķ���������������Ƿ����Ŀ��Ԫ�أ�
	 * ������ڣ�������Ҫ�ҳ��������������������е�ÿ��Ԫ�����������໥��Ӧ����÷������ǹ�ϣ��
	 * 
	 * ͨ���Կռ任ȡ�ٶȵķ�ʽ�����ǿ��Խ�����ʱ���O(n)��ΪO(1)��ϣ����ʽΪ��Ŀ�Ķ������ģ���֧���Խ��ƺ㶨��ʱ��
	 * ���п��ٲ��ҡ�
	 * ʱ�临�Ӷȣ�O(n)   �ռ临�Ӷȣ�O(n)
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
	
	//һ���ϣ��
	//ʱ�临�Ӷ�O(n)  �ռ临�Ӷ�O(n)
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
