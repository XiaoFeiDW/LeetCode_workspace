package dxh.leetcode;
import java.util.*;
public class T4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {};
		int[] B = {3};
//		int m = A.length;
//		int n = B.length;
//		
//		A = Arrays.copyOf(A, m + n);
		
		double num = findMedianSortedArrays(A, B);
//		for(int num : A) {
//			System.err.println(num);
//		}
//		
		System.out.println(num);
	}
	 
	//分治算法   时间复杂度O(log(m+n))
	public static double findMedianSortedArrays(int[] A, int[] B) {
		
		int m = A.length;
		int n = B.length;
		
		if(m ==0 && n == 1){
            return B[0] / 1.0;
        }
         if(m ==1 && n == 0){
            return A[0] / 1.0;
        }
		if(m > n) {    //确保n>=m
			int[] temp = A; A = B; B = temp;
			int tmp = m; m = n; n = tmp;
		}
		//在A、B中各找第i、j位置，使得A[0]-A[i-1] 和 B[0]-B[j-1]中最大的数小于A[i]-A[m-1] 和 B[j]-B[n-1]中最小的数
		//因为查找的是排序数组的中位数，所以有i+j=m-i+n-j  (或者m-i+n-j+1)，如果n>=m ,又0<=i<=m,所以j=(m+n+1)/2-i,为保证j>0,所以n>=m
		//左边为A[0]-A[i-1] + B[0]-B[j-1]  右边为A[i]-A[m-1] + B[j]-B[n-1]
		int iMin = 0, iMax = m;  //i的范围为0~m  
		int halfLen = (m + n + 1) / 2;
		while(iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			//对i进行调整
			if(i < iMax && B[j - 1] > A[i]) {
				iMin = i + 1; //i太小
			}else if(i > iMin && A[i - 1] > B[j]) {
				iMax = i - 1; //i太大
			}else {  //i刚好
				//maxLeft是A[0]-A[i-1] + B[0]-B[j-1]中最大的数值
				int maxLeft = 0;
				if(i == 0) {
					maxLeft = B[j - 1];
				}else if(j == 0) {
					maxLeft = A[i - 1];
				}else {
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				}
				
				//minRight是A[i]-A[m-1] + B[j]-B[n-1]中最小的数值
				int minRight = 0;
				if(i == m) {
					minRight = B[j];
				}else if(j == n){
					minRight = A[i];
				}else {
					minRight = Math.min(B[j], A[i]);
				}
				
				if((m + n) % 2 == 1) {
					return maxLeft;
				}else {
					return (maxLeft + minRight) / 2.0;
				}
			}
		}
		
		return 0.0;
	}
	
	
	//常规方法  将一个数组合并到另一个数组  时间复杂度O(m+n)  16ms
	public static double findMedianSortedArrays1(int[] A, int[] B) {
		
		int m = A.length;
		int n = B.length;
		
		
		//System.arraycopy(src, srcPos, dest, destPos, length)  
		//src为原数组，srcPos为从原数组的起始位置开始，dest为目标数组，destPos为目标数组的开始起始位置，length为要copy的数组的长度
		A = Arrays.copyOf(A, m + n);  //对数组A进行扩容，使其能够存下A、B的数
		System.arraycopy(B, 0, A, m, n);  //将数组B的数据拷入A数组内
		Arrays.sort(A);           //对数组A进行排序
		for(int n1:A) {
			System.out.println(n1);
		}
		int len = m + n;
		int mid = len / 2;
		
		if(len % 2 == 0) {
			return (A[mid] + A[mid - 1]) / 2.0;
		}
		
		return (double)A[mid];
	}

}
