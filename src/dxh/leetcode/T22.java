package dxh.leetcode;

import java.util.ArrayList;
import java.util.List;

/*���� n �����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
���磬���� n = 3�����ɽ��Ϊ��
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
public class T22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> l = new ArrayList<>();
		l = generateParenthesis(3);
		for(String l1 : l) {
			System.out.println(l1);
		}
	}
	
	public static List<String> generateParenthesis(int n){
		
		List<String> l = new ArrayList<>();
		generateParent(n, n, l, "");
		
		return l;
	}
	
	public static void generateParent(int right, int left, List<String> l, String str) {
		
		if(left == 0 && right == 0) {
			l.add(str);
		}
		
		if(right > left) {
			generateParent(right - 1, left, l, str + ")");
		}
		if(left > 0) {
			generateParent(right, left - 1, l, str + "(");
		}
		
		
	}

}
