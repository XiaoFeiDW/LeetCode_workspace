package dxh.backtracking;
/*����һ���ַ�������������е�����*/
public class QuestionOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		sortsOfString(s, "");

	}
	
	public static void sortsOfString(String s, String temp) { //����ʱ����temp���洢���
		if(s.length() == 0) {
			System.out.println(temp);
			return;
		}
		for(int i = 0; i < s.length(); i++) {
			String news = s.substring(0, i) + s.substring(i+1, s.length()); //ȥ��String�е�ĳ����ĸ
			sortsOfString(news, s.charAt(i) + temp);
		}
		
	}

}
