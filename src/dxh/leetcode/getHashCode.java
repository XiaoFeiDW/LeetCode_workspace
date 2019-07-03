package dxh.leetcode;

import java.util.Objects;

public class getHashCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "123";
		String str2 = "fghdasd";
//		System.err.println(getHashCode(str1));
//		System.err.println(str1.hashCode());
//		System.err.println(Objects.hash(str1));
		System.err.println(Integer.parseInt(str1));
	}
	
	public static long getHashCode(String str) {
		int hash = 0;
		for(int i = 0; i < str.length(); i++) {
			hash = 31 * hash + str.charAt(i);
//			System.out.println(hash);
		}
		
		return hash;
	}
	
	
	public static long getHashCode1 (String str) {
        int hash = 1315423911;
        int i;
        char ch;
        for (i = str.length() - 1; i >= 0; i--) {
            ch = str.charAt(i);
            hash ^= ((hash << 5) + ch + (hash >> 2));  //^=Òì»ò  a ^= b ==> a = a^b 
        }
        return (hash & 0x7FFFFFFF);
    }

}
