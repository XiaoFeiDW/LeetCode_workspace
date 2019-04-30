package dxh.leetcode;
/*����һ���ַ��� (s) ��һ���ַ�ģʽ (p)��ʵ��֧�� '.' �� '*' ��������ʽƥ�䡣

'.' ƥ�����ⵥ���ַ���
'*' ƥ���������ǰ���Ԫ�ء�
ƥ��Ӧ�ø��������ַ��� (s) �������ǲ����ַ�����

˵��:

s ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ��
p ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ���Լ��ַ� . �� *��
ʾ�� 1:

����:
s = "aa"
p = "a"
���: false
����: "a" �޷�ƥ�� "aa" �����ַ�����
ʾ�� 2:

����:
s = "aa"
p = "a*"
���: true
����: '*' �����ƥ���������ǰ���Ԫ��, ������ƥ�� 'a' �����, �ظ� 'a' һ��, �ַ����ɱ�Ϊ "aa"��
ʾ�� 3:

����:
s = "ab"
p = ".*"
���: true
����: ".*" ��ʾ��ƥ���������('*')�����ַ�('.')��
ʾ�� 4:

����:
s = "aab"
p = "c*a*b"
���: true
����: 'c' ���Բ����ظ�, 'a' ���Ա��ظ�һ�Ρ���˿���ƥ���ַ��� "aab"��
ʾ�� 5:

����:
s = "mississippi"
p = "mis*is*p*."
���: false*/
//��̬�滮�ͻ����㷨һ��ʹ��
public class T10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		String p = ".*";
		System.out.println(isMatch(s, p));
	}
	
	public static boolean isMatch(String s, String p) {
		if(p.equals(".*")) {   //".*"��ʾ��ƥ���������('*')�����ַ�('.')
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
		
		//�ַ�����ģʽͬʱ����ĩβ
		if(sIndex == s.length() && pIndex == p.length()) {
			return true;
		}
		if(sIndex != s.length() && pIndex ==p.length()) {
			return false;
		}
	
		//��һ���ַ����ַ�*
		if(pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
			if((sIndex != s.length() && s.charAt(sIndex) == p.charAt(pIndex)) || 
					(sIndex != s.length() && p.charAt(pIndex) == '.')) {
				return matchChar(s, sIndex, p, pIndex + 2) || matchChar(s, sIndex + 1, p, pIndex + 2)
						|| matchChar(s, sIndex + 1, p, pIndex);
			}else {
//				return matchChar(s, sIndex, p, pIndex + 2);
				return false;
			}
		//��һ���ַ������ַ�*	
		}else if((sIndex != s.length() && s.charAt(sIndex) == p.charAt(pIndex)) || 
					(sIndex != s.length() && p.charAt(pIndex) == '.')){
			return matchChar(s, sIndex + 1, p, pIndex + 1);
		}
		
		return false;
	}

}
