package dxh.leetcode;
/*��дһ�������������ַ��������е������ǰ׺��

��������ڹ���ǰ׺�����ؿ��ַ��� ""��

ʾ�� 1:

����: ["flower","flow","flight"]
���: "fl"
ʾ�� 2:

����: ["dog","racecar","car"]
���: ""
����: ���벻���ڹ���ǰ׺��*/
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
				 if(strs[j].charAt(i) == ch && j == strs.length - 1) {  //&& j == strs.length - 1�����ѱȽϵ������ַ��������һ���ַ�����
					 str += ch;
				 }
			 }
		 }
		 return str;
	}
}
