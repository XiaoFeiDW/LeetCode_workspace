package dxh.leetcode;

import java.util.ArrayList;
import java.util.List;

/*��һ�������ַ������ݸ������������Դ������¡������ҽ��� Z �������С�
���������ַ���Ϊ "LEETCODEISHIRING" ����Ϊ 3 ʱ���������£�
L   C   I   R
E T O E S I I G
E   D   H   N
֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"LCIRETOESIIGEDHN"��
����ʵ��������ַ�������ָ�������任�ĺ�����
string convert(string s, int numRows);
ʾ�� 1:
����: s = "LEETCODEISHIRING", numRows = 3
���: "LCIRETOESIIGEDHN"
ʾ�� 2:
����: s = "LEETCODEISHIRING", numRows = 4
���: "LDREOEIIECIHNTSG"
����:
L     D     R
E   O E   I I
E C   I H   N
T     S     G*/
//�ҳ����ɱ�ɽ��
/*
��0�к����һ�еļ��Ϊ  (numRows - 1) * 2
����ÿ�еĵ�һ�����Ϊ  (numRows - 1) * 2 - 2 * i   i��ʾ����
�ڶ������Ϊ    (numRows - 1) * 2 - ��һ�����
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
