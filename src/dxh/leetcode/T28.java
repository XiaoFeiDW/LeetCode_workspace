package dxh.leetcode;
/*
 *实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-strstr
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 */

public class T28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String S = "ababaaaba";
		String S1 = "ef";
//		System.out.println(strStrKMP(S, S1));
		
		for(int n : acFail(S)) {
			System.out.print(n + 1);
		}
		System.out.println();
		for(int n : getNext1(S)) {
			System.err.print(n + 1);
		}
	}
	
	//截取字符串
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
                j = 0; 
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
		while(i < n) {
			if(j == -1 || haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
				if(j == m) {
					return i - j;
				}
			}else {
				j = next[j];
			}
		}
		
		return -1;
		
		
	}
	//获取子串的next值
	public static int[] getNext(String needle) {
		int[] next = new int[needle.length()];
		int i = 0;
        int j = -1;
        
        int len = needle.length();
        next[0] = -1;
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
	
	public static int[] getNext1(String str) {
		int[] next = new int[str.length()];
		
		int i = 0, j = -1;
		next[0] = -1;
		while(i < str.length() - 1) {
			if(j == -1 || str.charAt(i) == str.charAt(j)) {
				i++;
				j++;
				next[i] = j;
			}else {
				j = next[j];
			}
		}
		
		
		return next;
	}
	
	//ac状态机
	public static int[] acFail(String str) {
		int[] ac = new int[str.length()];
		
		ac[0] = -1;
		for(int i = 1; i < str.length(); i++) {
			ac[i] = -1;
			int j = i - 1;
			int fail = ac[j];
			while(fail >= -1) {
				if(str.charAt(fail + 1) == str.charAt(i)) {
					ac[i] = fail + 1;
					break;
				}
				if(fail >= 0) 
					fail = ac[fail];
				else
					break;
			}
		}
		
		return ac;
	}
}
