package dxh.leetcode;
/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
示例 1:
输入: "()"
输出: true
示例 2:
输入: "()[]{}"
输出: true
例 3:
输入: "(]"
输出: false
示例 4:
输入: "([)]"
输出: false
示例 5:
输入: "{[]}"
输出: true*/

import java.util.Stack;

public class T20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "[{}()]";
		
		System.err.println(isValid(s));
//		System.err.println(isRight('(', ')'));

	}
	
	public static boolean isValid(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		char[] chars = s.toCharArray();
		
		for(int i = 0; i < chars.length; i++) {
			if(stack.size() == 0) {
				stack.push(chars[i]);
			}
			else if(isRight(stack.peek(), chars[i])) {
				stack.pop();
			}else {
				stack.push(chars[i]);
			}
		}

		return stack.size() == 0;
		
	}

	public static boolean isRight(char ch1, char ch2) {
		return (ch1 == '(' && ch2 == ')') || (ch1 == '[' && ch2 == ']') || (ch1 == '{' && ch2 == '}');
	}
}
