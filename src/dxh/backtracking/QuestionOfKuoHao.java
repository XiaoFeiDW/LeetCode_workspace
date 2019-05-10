	package dxh.backtracking;

import java.util.ArrayList;
/*�����㷨��
 * ����n�����ţ����������е����п�����*/
public class QuestionOfKuoHao {

	public static void main(String[] args) {
		int n = 3;
		int leftNum = n, rightNum = n; //�����ź������Ÿ���n��
		ArrayList<String> results = new ArrayList<>(); //���ڴ�Ž�ռ�
		parentheses("", results, leftNum, rightNum);
		for(String s : results) {
			System.out.println(s);
		}
	}
	
	public static void parentheses(String subList, ArrayList<String> results, int leftNum, int rightNum) {
		if(leftNum == 0 && rightNum == 0) { //����
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
