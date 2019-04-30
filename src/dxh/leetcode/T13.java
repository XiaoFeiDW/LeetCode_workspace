package dxh.leetcode;

import java.util.HashMap;

/*
 * 罗马数字转整数*/

public class T13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "MCMXCIV";
		System.err.println(romanToInt(s));
	}
	
	public static int romanToInt(String s) {
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("I", 1);
		map.put("IV", 4);
		map.put("V", 5);
		map.put("IX", 9);
		map.put("X", 10);
		map.put("XL", 40);
		map.put("L", 50);
		map.put("XC", 90);
		map.put("C", 100);
		map.put("CD", 400);
		map.put("D", 500);
		map.put("CM", 900);
		map.put("M", 1000);
		
		int len = s.length();
		int num = 0;
		String roman = "";
		String roman1 = "";
		int i = 0;
		while(i < len) {

			roman = String.valueOf(s.charAt(i));
			if(i + 1 < len) {
				roman1 = String.valueOf(s.charAt(i + 1));
				if(map.get(roman) < map.get(roman1)) {
					roman = roman + roman1;
					i++;
				}
			}
			
			num += map.get(roman);
			i++;
			
		}
		
		return num;
	}
}
