package dxh.practice;

import java.util.HashMap;
import java.util.Map;

/*��̬�滮�㷨�ĺ��ľ��Ǽ�ס�Ѿ�����Ľ�
 * 1��ʹ�ñ���¼�㷨��ס�Ѿ�����Ľ�
 * 2���Ե�����
 * ��̬�滮��������Ԫ�أ������ӽṹ���߽硢״̬ת�Ʒ���ʽ
 * */

public class Dynamic_Programming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getTotalWays_dongtaiguihua(9));
	}



	//��̬�滮��򵥵�����
	/*��һ���߶���10��̨�׵�¥�ݣ����������ߣ�ÿ��һ��ֻ������1������2��̨�ס�Ҫ���ó��������һ���ж������߷���
	���磬ÿ����1��̨�ף�һ����10������������һ���߷������ǿ��Լ�д�� 1,1,1,1,1,1,1,1,1,1
	����¥�ݵ�̨���� ����ж������߷�*/
	
	//��򵥵�  �ݹ�ⷨ
	/*�����ߵ���8̨����x�ַ������ߵ���9̨����y�ַ��������ߵ���10̨��һ����x+y�ַ���
	 * ���ߵ���9̨�����ߵ���8̨�� ��7̨��Ҳ�����ƵĹ���*/
	public static int getTotalWays_digui(int n) {
		int totalSteps = 0;
		if(n <= 0) {
			return 0;
		}
		if(n == 1 || n == 2) {
			return n;
		}
		if(n > 0) {
			totalSteps = getTotalWays_digui(n - 1) + getTotalWays_digui(n - 2);
		}
		return totalSteps;
	}
	
	//����¼�㷨
	/*�ڵݹ��㷨�� �����Ŵ����ظ��ļ��㣬���Կ���ʹ�ù�ϣ���ݴ���ͬ�����ļ�����
	 * �õ�ʱȡ������*/
	public static int getTotalWays_beiwanglu(int n) {
		Map<Integer, Integer> map = new HashMap<>();
		if(n <= 0) {
			return 0;
		}
		if(n == 1 || n == 2) {
			return n;
		}
		
		//���hash���д�����������ļ���������ֱ��ȡ������������ڣ���Ҫ�������벢����
		if(map.containsKey(n)) {
			return map.get(n);
		}else {
			int value = getTotalWays_beiwanglu(n - 1) + getTotalWays_beiwanglu(n - 2);
			map.put(n, value);
			return value;
		}
	}
	
	
	//�Ե����Ϸ� 
	/*���������Ѿ��Ƶ�������ÿһ�εĵ��������У�ֻ��Ҫ����֮ǰ������״̬���Ϳ����Ƶ����µ�״̬
	 * ������Ҫ����¼�㷨��������ȫ������״̬�������Ķ�̬�滮*/
	public static int getTotalWays_dongtaiguihua(int n) {
		if(n <= 0) {
			return 0;
		}
		if(n == 1 || n == 2) {
			return n;
		}
		
		int i = 1, j = 2, total = 0;
		for(int m = 2; m < n; m++) {  //һ������Ҫ����n-2��
			total = i + j;
			i = j;
			j = total;
		}
		return total;
	}


}
