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
		if(m > n) {    //ȷ��n>=m
			int[] temp = A; A = B; B = temp;
			int tmp = m; m = n; n = tmp;
		}
		//��A��B�и��ҵ�i��jλ�ã�ʹ��A[0]-A[i-1] �� B[0]-B[j-1]��B[0 - j-1]��������С��A[i]-A[m-1] �� B[j]-B[n-1]����С����
		//����i+j=m-i+n-j(m-i+n-j+1) ��0<=i<=m,����j=(m+n+1)/2-i,Ϊ��֤j>0,����n>=m
		//���ΪA[0]-A[i-1] + B[0]-B[j-1]  �ұ�ΪA[i]-A[m-1] + B[j]-B[n-1]
		int iMin = 0, iMax = m;  //i�ķ�ΧΪ0~m  
		int halfLen = (m + n + 1) / 2;
		while(iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			//��i���е���
			if(i < iMax && B[j - 1] > A[i]) {
				iMin = i + 1; //i̫С
			}else if(i > iMin && A[i - 1] > B[j]) {
				iMax = i - 1; //i̫��
			}else {  //i�պ�
				//maxLeft��A[0]-A[i-1] + B[0]-B[j-1]��������ֵ
				int maxLeft = 0;
				if(i == 0) {
					maxLeft = B[j - 1];
				}else if(j == 0) {
					maxLeft = A[i - 1];
				}else {
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				}
				
				//minRight��A[i]-A[m-1] + B[j]-B[n-1]����С����ֵ
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
