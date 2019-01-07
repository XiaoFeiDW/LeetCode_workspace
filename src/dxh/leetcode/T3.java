package dxh.leetcode;
/*
 * ����һ���ַ������ҳ��������ظ��ַ�����Ӵ��ĳ���
 *
���룺"abcabcbb"
���: 3 
����: ���ظ��ַ�����Ӵ��� "abc"���䳤��Ϊ 3��
����: "pwwkew"
���: 3
����: ���ظ��ַ�����Ӵ��� "wke"���䳤��Ϊ 3��
     ��ע�⣬�𰸱�����һ���Ӵ���"pwke" ��һ�������� �������Ӵ���
 * */

//���ⷨ��ʹ�õݹ飬�������ڲ��������Ƚϴ�ʱ��ʱ�临�Ӷȹ��ߣ�ͨ����
public class T3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("bcdefghijklmnopqrstuvwxyzABCD"));

	}
	
	@SuppressWarnings("null")
	public static int lengthOfLongestSubstring(String s) {
		
		//�߽�����
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

}
