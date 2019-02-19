package dxh.queueandstack;

/*给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 
输入: n = 12 
输出: 3 
解释: 12 = 4 + 4 + 4.

输入: n = 13
输出: 2
解释: 13 = 4 + 9.*/
//自底向上的解决问题方法

public class NumSquares {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i < 10; i++) {
			System.err.println(numSquares(i));
		}

	}
	
	public static int numSquares(int n) {
		
		//边界
		if(n == 1) {
			return 1;
		}
		
		//用数组保存每个正整数
		int count[] = new int[n + 1];
		count[1] = 1;
		count[0] = 0;
		
		for(int i = 2; i <= n; i++) {
			count[i] = n;
		}
	
		
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j * j <= i; j++) {
				count[i] = Math.min(count[i], (1 + count[i - j * j]));
				
			}
		}
		
		return count[n];
		
		
		
	}


}
