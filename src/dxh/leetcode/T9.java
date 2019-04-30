package dxh.leetcode;

public class T9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        System.err.println(isPalindrome(121));
	

	}
	 public static boolean isPalindrome1(int x) {
	        //只反转数字的一半
		 if(x < 0 || (x % 10 == 0 && x != 0))
			 return false;
	   
	        int num = 0;

	        while(x > num){
	            num = 10 * num + x % 10;
	            x /= 10;
	            
	        }
	       
	        return x == num || x == num / 10;
	    }
	 
	 public static boolean isPalindrome(int x) {
		 
		 if(x < 0)
			 return false;
		 
		 String str = String.valueOf(x);
		 int len = str.length();
		 int i = 0;
		 while(i < len) { 
			 if(str.charAt(i) != str.charAt(len - 1 - i)) {
				 return false;
			 }
			 i++;
			
		 }
		 
		 return true;
	 }

}
