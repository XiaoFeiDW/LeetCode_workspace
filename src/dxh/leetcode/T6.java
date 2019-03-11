package dxh.leetcode;

import java.util.ArrayList;
import java.util.List;

/*将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);
示例 1:
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:
输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:
L     D     R
E   O E   I I
E C   I H   N
T     S     G*/
//找出规律便可解答
/*
第0行和最后一行的间隔为  (numRows - 1) * 2
其余每行的第一个间隔为  (numRows - 1) * 2 - 2 * i   i表示行数
第二个间隔为    (numRows - 1) * 2 - 第一个间隔
*/
public class T6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "AB";
		System.err.println(convert(s, 1));
	}
	
	public static String convert(String s, int numRows) {
		
		String str = "";
		if(s.length() < numRows || numRows == 1) {
			return s;
		}
		for(int i = 0; i < numRows; i++) {
			if(i == 0 || i == numRows - 1) {
				for(int j = i; j < s.length(); j += (numRows - 1) * 2) {
					str += s.charAt(j);
				}
			}
			else{
				int m = (numRows - 1) * 2 - 2 * i;
				int n = (numRows - 1) * 2 - m;
				int k = i + m;
				str += s.charAt(i);
				while(k < s.length()) {
					str += s.charAt(k);
					k = k + n;
					if(k < s.length()) {
						str += s.charAt(k);
						k = k + m;
					}
				}
			}
		}
		return str;
	}
}
