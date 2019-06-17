package dxh.leetcode;

public class T28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String S = "abcdef";
		String S1 = "cd";
		System.out.println(strStrKMP(S, S1));
	}
	
	public static int strStr(String haystack, String needle) {
		
		int len1 = haystack.length();
		int len2 = needle.length();
		
		if(len2 == 0) {
			return 0;
		}
		if(len2 > len1) {
			return -1;
		}
		
		int pos = 0, i;
		if(pos >= 0) {
			i = pos;
			while(i < len1 - len2 + 1) {
				String str = haystack.substring(i, i + len2);
				
				if(!needle.equals(str)) {
					++i;
				}else {
					return i;
				}
			}
		}
		
		return -1;	
		
	}
	
	//朴素模式匹配算法
	public static int strStr1(String haystack, String needle) {
		   
        if(needle.length() == 0){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        
        int i = 0, j = 0;
        while(i < haystack.length()){
            if(haystack.charAt(i) != needle.charAt(j)){
                i++;
                if(i < haystack.length()){
                    i = i - j + 2;
                    j = 0;
                   
                }    
            }else{
                i++;
                j++;
                if(j == needle.length()){
                     return i - j;
                }  
            }
        }
        return -1;
	}

	//KMP模式匹配算法
	public static int strStrKMP(String haystack, String needle) {
		
		int n = haystack.length(), m = needle.length();
		int[] next = getNext(needle);
		
		int i = 0, j = 0;
		while(i < n && j < m) {
			if(j == -1 || needle.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			}else {
				j = next[j];
			}
		}
		if(j == m) {
			return i - j;
		}else {
			return -1;
		}
		
	}
	//获取子串的next值
	public static int[] getNext(String needle) {
		int[] next = new int[needle.length()];
		int i = 0;
        int j = -1;
        next[0] = -1;
        int len = needle.length();
        while(i < len-1){
            if(j == -1 || needle.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                next[i] = j;
            }else{
                j = next[j];
            }
        }
		return next;
	}
}
