package dxh.leetcode;
/*���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ���� (i, ai) ��
 * �������ڻ� n ����ֱ�ߣ���ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0)��
 * �ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��*/
public class T11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}
	
	//�˽ⷨʱ�临�Ӷ�ΪO(n^2)���ռ临�Ӷ�O(1)
	public static int maxArea1(int[] height) {
		
		int num1, num2;
		int sum = 0;
		for(int i = 0; i < height.length; i++) {
			for(int j = i + 1; j < height.length; j++) {
				num1 = height[i];
				num2 = height[j];
				int len = j - i;
				int high = num1 < num2 ? num1 : num2;
				sum = sum > (len * high) ? sum : (len * high); 
			}
		}
		
		return sum;
	}
	
	//ʱ�临�Ӷ�O(n)
	public static int maxArea(int[] height) {
		int i = 0, j = height.length - 1, maxarea = 0;
		while(i < j) {
			maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
			if(height[i] < height[j]) {
				i++;
			}else {
				j--;
			}
		}
		
		return maxarea;
	}

}
