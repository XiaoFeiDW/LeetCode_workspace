package dxh.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
示例：
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].*/

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
		}else {		//i = len - 1,说明到达digits的最后一个字符
			for(int j = 0; j < map.get(String.valueOf(digits.charAt(i))).length(); j++) {
				list.add(String.valueOf(str + map.get(String.valueOf(digits.charAt(i))).charAt(j)));
			}
		}
	}

}
