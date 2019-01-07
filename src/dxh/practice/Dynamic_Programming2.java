package dxh.practice;

/*
 *��һ�����ҷ�����5�����ÿ�����Ļƽ�����ͬ����Ҫ�����ھ�Ĺ�����Ҳ��ͬ�������ڿ��˵�������10��
 *ÿ�����Ҫôȫ�ڣ�Ҫô���ڣ������ɳ�һ������ȡһ���󣬣�Ҫ��õ������ܶ�Ļƽ�Ӧ��ѡ����ȡ�ļ������
 *��������ܽ������蹤�˷ֱ�Ϊ  400��/5��  500��/5��  200��/3��   300��/4��     350��/3��
 *����������ӽṹ��ȡ���ڵ���������ڻ��ǲ���  ���������ӽṹ��10����ǰ4�������ѡ�񣨲��ڵ�5���󣩺�
 *7����ǰ4�������ѡ���ڵ�5�����Լ���5���������֮�͵����ֵ
 *���ڿ�������W ����N��ÿ���������G[]  ���Կ��Եó��ڽ�����F(N, W) = Max(F(N - 1, W), F(N-1, W-(�����һ������������))+���һ���������)
*/
public class Dynamic_Programming2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//g��ÿ�����������p��ÿ�������������
	public static int getMostGold(int n, int w, int[] g, int[] p) {
		
		//����ȷ���߽�
		
		int[] preResults = new int[p.length];
		int[] results = new int[p.length];
		
		//���߽���ӵ�ֵ
		for(int i = 0; i <= n; i++) {
			if(i < p[0]) {
				preResults[i] = 0;
			}else {
				preResults[i] = g[0];
			}
		}
		
		//���������ӵ�ֵ�����ѭ���ǽ���������ڲ�ѭ���ǹ�����
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= w; j++) {
				if(j < p[i]) {
					results[j] = preResults[j];
				}else {
					results[j] = Math.max(preResults[j], preResults[j - p[i]] + g[i]);
				}
			}
		}
		
		return results[n];
	}
	
	

}
