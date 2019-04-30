package dxh.leetcode;
/*给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。*/
public class T11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}
	
	//此解法时间复杂度为O(n^2)，空间复杂度O(1)
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
	
	//时间复杂度O(n)
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
