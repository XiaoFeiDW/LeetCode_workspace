package dxh.practice;

import java.util.HashMap;
import java.util.Map;

/*动态规划算法的核心就是记住已经求过的解
 * 1、使用备忘录算法记住已经求过的解
 * 2、自底向上
 * 动态规划三个核心元素：最优子结构、边界、状态转移方程式
 * */

public class Dynamic_Programming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getTotalWays_dongtaiguihua(9));
	}



	//动态规划最简单的例子
	/*有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
	比如，每次走1级台阶，一共走10步，这是其中一种走法。我们可以简写成 1,1,1,1,1,1,1,1,1,1
	给出楼梯的台阶数 求解有多少种走法*/
	
	//最简单的  递归解法
	/*假如走到第8台阶有x种方法，走到第9台阶有y种方法，则走到第10台阶一共有x+y种方法
	 * 则走到第9台阶与走到第8台阶 第7台阶也是类似的规律*/
	public static int getTotalWays_digui(int n) {
		int totalSteps = 0;
		if(n <= 0) {
			return 0;
		}
		if(n == 1 || n == 2) {
			return n;
		}
		if(n > 0) {
			totalSteps = getTotalWays_digui(n - 1) + getTotalWays_digui(n - 2);
		}
		return totalSteps;
	}
	
	//备忘录算法
	/*在递归算法中 存在着大量重复的计算，所以可以使用哈希表暂存相同参数的计算结果
	 * 用到时取出即可*/
	public static int getTotalWays_beiwanglu(int n) {
		Map<Integer, Integer> map = new HashMap<>();
		if(n <= 0) {
			return 0;
		}
		if(n == 1 || n == 2) {
			return n;
		}
		
		//如果hash表中存在所需参数的计算结果，则直接取出，如果不存在，需要计算后存入并返回
		if(map.containsKey(n)) {
			return map.get(n);
		}else {
			int value = getTotalWays_beiwanglu(n - 1) + getTotalWays_beiwanglu(n - 2);
			map.put(n, value);
			return value;
		}
	}
	
	
	//自底向上法 
	/*由于我们已经推导出，在每一次的迭代过程中，只需要保存之前的两个状态，就可以推导出新的状态
	 * 而不需要像备忘录算法那样保存全部的子状态，真正的动态规划*/
	public static int getTotalWays_dongtaiguihua(int n) {
		if(n <= 0) {
			return 0;
		}
		if(n == 1 || n == 2) {
			return n;
		}
		
		int i = 1, j = 2, total = 0;
		for(int m = 2; m < n; m++) {  //一共还需要迭代n-2次
			total = i + j;
			i = j;
			j = total;
		}
		return total;
	}


}
