package dxh.leetcode;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class T3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("bbbbb"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		
		int n = s.length();
		//Set集合的特点是不能存放重复元素，所以可将元素依次输入进去，若遇到重复元素时，则删除前一位
		Set<Character> set = new HashSet<>();
		int i = 0, j = 0, len = 0;
		while(i < n && j < n) {
			if(!set.contains(s.charAt(i))) {
				set.add(s.charAt(i));
				i++;
				len = Math.max(len, i - j);
			}else {
				set.remove(s.charAt(j));
				j++;
			}
		}
		
        return len;
  
	}

}
