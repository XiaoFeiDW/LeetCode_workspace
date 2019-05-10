package dxh.backtracking;
/*给出一个字符串，求出其所有的排列*/
public class QuestionOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		sortsOfString(s, "");

	}
	
	public static void sortsOfString(String s, String temp) { //用临时变量temp来存储结果
		if(s.length() == 0) {
			System.out.println(temp);
			return;
		}
		for(int i = 0; i < s.length(); i++) {
			String news = s.substring(0, i) + s.substring(i+1, s.length()); //去掉String中的某个字母
			sortsOfString(news, s.charAt(i) + temp);
		}
		
	}

}
