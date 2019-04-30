package dxh.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�

�������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
ʾ����
���룺"23"
�����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].*/

public class T17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digits = "23456";
		List<String> list = letterCombinations(digits);
		for(String s : list) {
			System.out.println(s);
		}

	}
	
	public static List<String> letterCombinations(String digits){
		
		List<String> list = new ArrayList<>();
		
		if(digits.length() == 0) {
			return list;
		}
		
		Map<String, String> map = new HashMap<>();
		map.put("2", "abc");
		map.put("3", "def");
		map.put("4", "ghi");
		map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs");
		map.put("8", "tuv");
		map.put("9", "wxyz");
		
		letter(digits, map, list, 0, "");
		
		return list;
	}
	
	public static void letter(String digits, Map<String, String> map, List<String> list, int i, String str) {
		if(i < digits.length() - 1) {
			for(int j = 0; j < map.get(String.valueOf(digits.charAt(i))).length(); j++) {				
				letter(digits, map, list, i+1, str + map.get(String.valueOf(digits.charAt(i))).charAt(j));
			}
			i++;
		}else {		//i = len - 1,˵������digits�����һ���ַ�
			for(int j = 0; j < map.get(String.valueOf(digits.charAt(i))).length(); j++) {
				list.add(String.valueOf(str + map.get(String.valueOf(digits.charAt(i))).charAt(j)));
			}
		}
	}

}
