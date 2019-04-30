package dxh.leetcode;
/*给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符。
'*' 匹配零个或多个前面的元素。
匹配应该覆盖整个字符串 (s) ，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false*/
//动态规划和回溯算法一起使用
public class T10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		String p = ".*";
		System.out.println(isMatch(s, p));
	}
	
	public static boolean isMatch(String s, String p) {
		if(p.equals(".*")) {   //".*"表示可匹配零个或多个('*')任意字符('.')
			return true;
		}
		if(s == null || p == null) {
			return false;
		}
		
		int sIndex = 0; 
		int pIndex = 0;
		
		return matchChar(s, sIndex, p, pIndex);
	}
	
	public static boolean matchChar(String s, int sIndex, String p, int pIndex) {
		
		//字符串和模式同时到达末尾
		if(sIndex == s.length() && pIndex == p.length()) {
			return true;
		}
		if(sIndex != s.length() && pIndex ==p.length()) {
			return false;
		}
	
		//下一个字符是字符*
		if(pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
			if((sIndex != s.length() && s.charAt(sIndex) == p.charAt(pIndex)) || 
					(sIndex != s.length() && p.charAt(pIndex) == '.')) {
				return matchChar(s, sIndex, p, pIndex + 2) || matchChar(s, sIndex + 1, p, pIndex + 2)
						|| matchChar(s, sIndex + 1, p, pIndex);
			}else {
//				return matchChar(s, sIndex, p, pIndex + 2);
				return false;
			}
		//下一个字符不是字符*	
		}else if((sIndex != s.length() && s.charAt(sIndex) == p.charAt(pIndex)) || 
					(sIndex != s.length() && p.charAt(pIndex) == '.')){
			return matchChar(s, sIndex + 1, p, pIndex + 1);
		}
		
		return false;
	}

}
