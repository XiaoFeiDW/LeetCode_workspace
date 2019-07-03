package dxh.leetcode;
/*定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

示例 1:

输入: dividend = 10, divisor = 3
输出: 3
示例 2:

输入: dividend = 7, divisor = -3
输出: -2
说明:

被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/divide-two-integers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class T29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int dividend = -1;
		int divisor = -1;
		
		System.out.println(divide(dividend, divisor));
	
	}
	
	public static int divide(int dividend, int divisor) {
	
       int divide = 0;
       if(divisor == 0) {
    	   return 0;
       }
       if(dividend == Integer.MIN_VALUE && divisor == -1) {
    	   return Integer.MAX_VALUE;
       }
       
       long m = Math.abs((long)dividend);
       long n = Math.abs((long)divisor);
       boolean flag = (dividend ^ divisor) < 0;
       for(int i = 31; i >= 0; i--) {
    	   if((m>>i) >= n) {
    		   divide += 1<<i;
    		   m -= n<<i;
    	   }
       }
       
       
       return flag ? -divide : divide;
	}

}
