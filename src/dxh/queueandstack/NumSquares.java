package dxh.queueandstack;

/*���������� n���ҵ����ɸ���ȫƽ���������� 1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n������Ҫ����ɺ͵���ȫƽ�����ĸ������١�
 * 
����: n = 12 
���: 3 
����: 12 = 4 + 4 + 4.

����: n = 13
���: 2
����: 13 = 4 + 9.*/
//�Ե����ϵĽ�����ⷽ��

public class NumSquares {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i < 10; i++) {
			System.err.println(numSquares(i));
		}

	}
	
	public static int numSquares(int n) {
		
		//�߽�
		if(n == 1) {
			return 1;
		}
		
		//�����鱣��ÿ��������
		int count[] = new int[n + 1];
		count[1] = 1;
		count[0] = 0;
		
		for(int i = 2; i <= n; i++) {
			count[i] = n;
		}
	
		
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j * j <= i; j++) {
				count[i] = Math.min(count[i], (1 + count[i - j * j]));
				
			}
		}
		
		return count[n];
		
		
		
	}


}
