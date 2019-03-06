package dxh.leetcode;

public class T4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {1,2,3,4,5,6};
		int[] B = {3,6,7,8};
		double num = findMedianSortedArrays(A, B);
		System.err.println(num);
		
	}
	
	public static double findMedianSortedArrays(int[] A, int[] B) {
		
		int m = A.length;
		int n = B.length;
		if(m > n) {    //确保n>=m
			int[] temp = A; A = B; B = temp;
			int tmp = m; m = n; n = tmp;
		}
		//在A、B中各找第i、j位置，使得A[0]-A[i-1] 和 B[0]-B[j-1]和B[0 - j-1]中最大的数小于A[i]-A[m-1] 和 B[j]-B[n-1]中最小的数
		//则有i+j=m-i+n-j(m-i+n-j+1) 又0<=i<=m,所以j=(m+n+1)/2-i,为保证j>0,所以n>=m
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

}
