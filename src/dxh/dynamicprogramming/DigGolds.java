package dxh.dynamicprogramming;



/*��һ�����ҷ�����5�����ÿ�����Ļƽ�����ͬ����Ҫ�����ھ�Ĺ�����Ҳ��ͬ�������ڿ��˵�������10�ˡ�
 * ÿ�����Ҫôȫ�ڣ�Ҫô���ڣ������ɳ�һ������ȡһ����Ҫ���ó���������Ҫ��õ������ܶ�Ļƽ�Ӧ��ѡ����ȡ�ļ������
 * �������蹤�˷ֱ�Ϊ200��/3�ˡ�300��/4�ˡ�350��3�ˡ�400��/5�ˡ�500��/5��*/

public class DigGolds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;
		int p = 10;
		int[] golds = {200, 300, 350, 400, 500};
		int[] people = {3, 4, 3, 5, 5};
//		System.out.println(getMostGoldsByDiGui(n, p, golds, people));
		System.err.println(getBestWaysByDP(n, p, golds, people));
		
	}
	//�ݹ�
	public static int getMostGoldsByDiGui(int n, int p, int[] golds, int[] people) {
		
		if(n <= 1 || p < people[0]) {
			return 0;
		}
		if(n == 1 && p >= people[0]) {
			return golds[0];
		}
		
		return Math.max(getMostGoldsByDiGui(n - 1, p, golds, people),
				getMostGoldsByDiGui(n - 1, p - people[n - 1], golds, people) + golds[n - 1]);
	}

	//��̬�滮��n����������p���˵�������goldsΪ����������飬peopleΪÿ�������Ҫ���˵�����
	public static int getBestWaysByDP(int n, int p, int[] golds, int[] people) {
		
		int[] firstResult = new int[p];
		int[] result = new int[p];
		
		for(int i = 1; i <= p; i++) {  //��ֻ��һ�����ʱ���ܿ��ɵĻƽ�����
			if(i < people[0]) {
				firstResult[i - 1] = 0;
			}else {
				firstResult[i - 1] = golds[0];
			}
		}
		
		//���߽���ӵ�ֵ
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= p; j++) {
				//��Ҫ��������±�Ϊ��������
				result[j - 1] = Math.max(firstResult[j - 1], firstResult[j - 1 - people[i - 1]] + golds[i - 1]);
			}
			for(int k = 0; k < 10; k++) {
				firstResult[k] = result[k];
			}
		}
		
		return result[p - 1];
	}

}
