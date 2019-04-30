package dxh.leetcode;
/*����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
��Ч�ַ��������㣺
�����ű�������ͬ���͵������űպϡ�
�����ű�������ȷ��˳��պϡ�
ע����ַ����ɱ���Ϊ����Ч�ַ�����
ʾ�� 1:
����: "()"
���: true
ʾ�� 2:
����: "()[]{}"
���: true
�� 3:
����: "(]"
���: false
ʾ�� 4:
����: "([)]"
���: false
ʾ�� 5:
����: "{[]}"
���: true*/

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
