package dxh.leetcode;
/*编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。*/
public class T14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs =  {"flower"};
		
		
		System.err.println(longestCommonPrefix(strs));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		 if(strs.length == 0) {
			 return strs[0];
		 }
		 
		 String str = "";
		 String str1 = strs[0];
		 int len = str1.length();
		 for(int i = 0; i < len; i++) {
			 char ch = str1.charAt(i);
			 for(int j = 1; j < strs.length; j++) {
				 if(strs[j].length() < i || strs[j].charAt(i) != ch) {
					 return str;
				 }
				 if(strs[j].charAt(i) == ch && j == strs.length - 1) {  //&& j == strs.length - 1表明已比较到数组字符串中最后一个字符串了
					 str += ch;
				 }
			 }
		 }
		 return str;
	}
}
