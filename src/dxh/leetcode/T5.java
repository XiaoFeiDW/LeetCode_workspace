package dxh.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

示例 2：

输入: "cbbd"
输出: "bb"
 * */
public class T5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "baabad";
		String str = longestPalindrome(s);
		
		System.err.println(str);
	}
	
	//寻找最长回文子串
	public static String longestPalindrome(String s) {
		
		if(s.length() < 2) {
			return s;
		}
		int start = 0, end = 0;
		for(int i = 0; i < s.length(); i++) {
			int len1 = getLength(s, i, i);
			int len2 = getLength(s, i, i + 1); //回文子串个数为偶数
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
