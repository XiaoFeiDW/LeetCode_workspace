package dxh.practice;

/*
 *有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。参与挖矿工人的总数是10人
 *每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿，，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
 *五座金矿总金额和所需工人分别为  400金/5人  500金/5人  200金/3人   300金/4人     350金/3人
 *该题的最优子结构是取决于第五座金矿挖还是不挖  所以最优子结构是10人挖前4矿的最优选择（不挖第5座矿）和
 *7人挖前4矿的最优选择（挖第5座矿）以及第5座矿的数量之和的最大值
 *设挖矿总人数W 矿数N，每个矿的数量G[]  所以可以得出挖金数量F(N, W) = Max(F(N - 1, W), F(N-1, W-(挖最后一个矿所需人数))+最后一个矿的数量)
*/
public class Dynamic_Programming2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//g是每个矿的数量，p是每个矿所需的人数
	public static int getMostGold(int n, int w, int[] g, int[] p) {
		
		//首先确定边界
		
		int[] preResults = new int[p.length];
		int[] results = new int[p.length];
		
		//填充边界格子的值
		for(int i = 0; i <= n; i++) {
			if(i < p[0]) {
				preResults[i] = 0;
			}else {
				preResults[i] = g[0];
			}
		}
		
		//填充其余格子的值，外层循环是金矿数量，内层循环是工人数
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= w; j++) {
				if(j < p[i]) {
					results[j] = preResults[j];
				}else {
					results[j] = Math.max(preResults[j], preResults[j - p[i]] + g[i]);
				}
			}
		}
		
		return results[n];
	}
	
	

}
