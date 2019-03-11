package dxh.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
ʾ�� 1��

����: "babad"
���: "bab"
ע��: "aba" Ҳ��һ����Ч�𰸡�

ʾ�� 2��

����: "cbbd"
���: "bb"
 * */
public class T5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "baabad";
		String str = longestPalindrome(s);
		
		System.err.println(str);
	}
	
	//Ѱ��������Ӵ�
	public static String longestPalindrome(String s) {
		
		if(s.length() < 2) {
			return s;
		}
		int start = 0, end = 0;
		for(int i = 0; i < s.length(); i++) {
			int len1 = getLength(s, i, i);
			int len2 = getLength(s, i, i + 1); //�����Ӵ�����Ϊż��
			int len = Math.max(len1, len2);
			if(len > end - start) {
				start = i - (len - 1) / 2;
				end = start + len - 1;
			}
		}
		return s.substring(start, end + 1);
	}
	
	public static int getLength(String s, int i, int j) {
		
		while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			
			i--;
			j++;
		}
		return j - i - 1;
	}
	
	
}
