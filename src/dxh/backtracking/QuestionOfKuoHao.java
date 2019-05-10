	package dxh.backtracking;

import java.util.ArrayList;
/*回溯算法：
 * 给出n对括号，求括号排列的所有可能性*/
public class QuestionOfKuoHao {

	public static void main(String[] args) {
		int n = 3;
		int leftNum = n, rightNum = n; //左括号和右括号各有n个
		ArrayList<String> results = new ArrayList<>(); //用于存放解空间
		parentheses("", results, leftNum, rightNum);
		for(String s : results) {
			System.out.println(s);
		}
	}
	
	public static void parentheses(String subList, ArrayList<String> results, int leftNum, int rightNum) {
		if(leftNum == 0 && rightNum == 0) { //结束
			results.add(subList);
		}
		
		if(rightNum > leftNum) {
			parentheses(subList + ")", results, leftNum, rightNum - 1);
		}
		
		if(leftNum > 0) {
			parentheses(subList + "(", results, leftNum - 1, rightNum);
		}
	}
}
