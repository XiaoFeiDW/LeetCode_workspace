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

	}
	
	//寻找最长回文子串
	public String longestPalindrome(String s) {
		
		List<String> strList = new ArrayList<>(); 
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i + 1) == s.charAt(i-1)) {
				
			}
		}
		
		return "";
	}

}
