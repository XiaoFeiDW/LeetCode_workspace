package dxh.dynamicprogramming;



/*有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。参与挖矿工人的总数是10人。
 * 每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
 * 金矿和所需工人分别为200金/3人、300金/4人、350金3人、400金/5人、500金/5人*/

public class DigGolds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;
		int p = 10;
		int[] golds = {200, 300, 350, 400, 500};
		int[] people = {3, 4, 3, 5, 5};
//		System.out.println(getMostGoldsByDiGui(n, p, golds, people));
		System.err.println(getBestWaysByDP(n, p, golds, people));
		
	}
	//递归
	public static int getMostGoldsByDiGui(int n, int p, int[] golds, int[] people) {
		
		if(n <= 1 || p < people[0]) {
			return 0;
		}
		if(n == 1 && p >= people[0]) {
			return golds[0];
		}
		
		return Math.max(getMostGoldsByDiGui(n - 1, p, golds, people),
				getMostGoldsByDiGui(n - 1, p - people[n - 1], golds, people) + golds[n - 1]);
	}

	//动态规划：n金矿的数量，p工人的数量，golds为金矿量的数组，people为每个金矿需要工人的数组
	public static int getBestWaysByDP(int n, int p, int[] golds, int[] people) {
		
		int[] firstResult = new int[p];
		int[] result = new int[p];
		
		for(int i = 1; i <= p; i++) {  //当只有一个金矿时所能开采的黄金数量
			if(i < people[0]) {
				firstResult[i - 1] = 0;
			}else {
				firstResult[i - 1] = golds[0];
			}
		}
		
		//填充边界格子的值
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= p; j++) {
				//需要解决数组下标为负的问题
				result[j - 1] = Math.max(firstResult[j - 1], firstResult[j - 1 - people[i - 1]] + golds[i - 1]);
			}
			for(int k = 0; k < 10; k++) {
				firstResult[k] = result[k];
			}
		}
		
		return result[p - 1];
	}

}
