package dxh.dynamicprogramming;

import java.util.HashMap;

/*��һ���߶���10��̨�׵�¥�ݣ����������ߣ�ÿ��һ��ֻ������1������2��̨�ס�Ҫ���ó��������һ���ж������߷���*/
public class GetTotalWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(getTotalWaysByDigui(30));
//		System.err.println(getTotalWayByBeiwanglu(20));
		System.err.println(getTotalWaysByDG(20));
		
	}
	
	/*�ݹ�ⷨ:�����Զ����µ�˼·*/
	public static int getTotalWaysByDigui(int n) {
		if(n < 1) {
			return 0;
		}
		if(n == 1 || n == 2) {
			return n;
		}
		
		return getTotalWaysByDigui(n - 1) + getTotalWaysByDigui(n - 2);
	}
	
	/*����¼�㷨���ݹ��㷨�ĸĽ��������ڵݹ��㷨�У���Ҫ������Ѿ�������ģ��˷�ʱ��*/
	public static int getTotalWayByBeiwanglu(int n) {
		if(n < 1) {
			return 0;
		}
		if(n == 1 || n == 2) {
			return n;
		}
		int value = getTotalWayByBeiwanglu(n - 1) + getTotalWayByBeiwanglu(n - 2);
		HashMap<Integer, Integer> map = new HashMap<>();
		
		if(!map.containsKey(n)) {
			map.put(n, value);
			return value;
		}else {
			return map.get(n);
		}
		
	}

	/*��̬�滮���Ե����ϣ�ֻ��Ҫ���������ǰ����״̬*/
	public static int getTotalWaysByDG(int n) {
		if(n < 1) {
			return 0;
		}
		if(n == 1 || n == 2) {
			return n;
		}
		
		int a = 1;
		int b = 2;
		int temp = 0;
		for(int i = 3; i <= n; i++) {
			temp = a + b;
			a = b;
			b = temp;
		}
		return temp;
	}

}
