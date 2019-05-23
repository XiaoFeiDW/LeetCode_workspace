package dxh.leetcode;

public class getHashCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "asdfghd";
		String str2 = "fghdasd";
		System.err.println(getHashCode1(str1));
//		System.err.println(getHashCode1(str2));
	}
	
	public static long getHashCode1 (String str) {
        int hash = 1315423911;
        int i;
        char ch;
        for (i = str.length() - 1; i >= 0; i--) {
            ch = str.charAt(i);
            hash ^= ((hash << 5) + ch + (hash >> 2));  //^=Òì»ò  a ^= b ==> a = a^b 
            System.out.println(hash);
        }
        return (hash & 0x7FFFFFFF);
    }

}
