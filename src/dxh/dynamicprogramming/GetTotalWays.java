package dxh.dynamicprogramming;

import java.util.HashMap;

/*有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。*/
public class GetTotalWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getTotalWaysByDigui(30));
//		System.err.println(getTotalWayByBeiwanglu(20));
		System.err.println(getTotalWaysByDG(20));
		
	}
	
	/*递归解法:采用自顶向下的思路*/
	public static int getTotalWaysByDigui(int n) {
		if(n < 1) {
			return 0;
		}
		if(n == 1 || n == 2) {
			return n;
		}
		
		return getTotalWaysByDigui(n - 1) + getTotalWaysByDigui(n - 2);
	}
	
	/*备忘录算法：递归算法的改进，由于在递归算法中，需要结果是已经计算过的，浪费时间*/
	public static int getTotalWayByBeiwanglu(int n) {
		if(n < 1) {
			return 0;
		}
		if(n == 1 || n == 2) {
			return n;
		}
		int value = getTotalWayByBeiwanglu(n - 1) + getTotalWayByBeiwanglu(n - 2);
		HashMap<Integer, Integer> map = new HashMap<>();
		
		if(!map.containsKey(n)) {
			map.put(n, value);
			return value;
		}else {
			return map.get(n);
		}
		
	}

	/*动态规划：自底向上，只需要保留所求的前两个状态*/
	public static int getTotalWaysByDG(int n) {
		if(n < 1) {
			return 0;
		}
		if(n == 1 || n == 2) {
			return n;
		}
		
		int a = 1;
		int b = 2;
		int temp = 0;
		for(int i = 3; i <= n; i++) {
			temp = a + b;
			a = b;
			b = temp;
		}
		return temp;
	}

}
