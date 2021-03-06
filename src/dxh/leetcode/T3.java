package dxh.leetcode;

import java.util.*;
/*
 * 给定一个字符串，找出不含有重复字符的最长子串的长度
 *
输入："abcabcbb"
输出: 3 
解释: 无重复字符的最长子串是 "abc"，其长度为 3。
输入: "pwwkew"
输出: 3
解释: 无重复字符的最长子串是 "wke"，其长度为 3。
     请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 * */

//本解法是使用递归，但是由于测试用例比较大时，时间复杂度过高，通不过
public class T3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("bcdefghijklmnopqrstuvwxyzABCD"));

	}
	
	@SuppressWarnings("null")
	public static int lengthOfLongestSubstring(String s) {
		
		//边界条件
		if(s.length() == 0) {
			return 0;
		}else if(s.length() == 1) {
			return 1;
		}
	
		String str1 = "";
		String str2 = "";
		char[] ch = s.toCharArray();
		int i;
		int len2 = 0;

		for(i = 1; i < s.length(); i++) {
			
			int j = 0; 
			while(j < i) {
				
				if(ch[i] != ch[j]) {
					if((i == s.length() - 1) && (j == (i - 1))) {     
						len2 = s.length();
					}
					j++;
				}
				else if(ch[i] == ch[j]){
					str1 = s.substring(0, i);
					str2 = s.substring(1, s.length());
					len2 = lengthOfLongestSubstring(str2);
					break;
				}	
			}
			
			if(str1 != "") {
				break;
			}
		}
		
		return str1.length() > len2 ? str1.length() : len2;
		
	}

	public static int lengthOfLongestSubString1(String s) {
		
		 Set<Character> strSet = new HashSet<>();  //set是无重复的集合
		 int i = 0, j = 0, len = 0;
		 
		 while(i < s.length() && j < s.length()) {
			 if(!strSet.contains(s.charAt(i))) {
				 strSet.add(s.charAt(i));
				 i++;
				 len = Math.max(len, i - j);  //只保留每次比较的字符串中长度最长的那个
			 }else {                          //当集合内存在相同的元素时，i不动，j++，直到集合内相同的元素删除完
				 strSet.remove(s.charAt(j));
				 j++;
			 }
		 }
		
		 return len;
	}
}
