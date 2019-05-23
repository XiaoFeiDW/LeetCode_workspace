package dxh.greedyalgorithm;
/*
 * �ֱ���1,5,10,50,100Ԫ���ֱ���5,2,2,3,5��ֽ�ҡ�����Ҫ֧��kԪ������Ҫ������ֽ�ң�*/
public class QuestionOfMoney {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(slove(2000));
	}

	public static int slove(int money) {
		int maxMoney = 100 *5 + 50 * 3 + 10 * 2 + 5 * 2 + 1 * 5;
		if(money < 1 || money > maxMoney) {
			return 0;
		}
		int num = 0;
		int[] moneys = {1, 5, 10, 50, 100};
		int[] nums = {5, 2, 2, 3, 5};
		
		for(int i = 4; i >= 0; i--) {
			int n = Math.min(money / moneys[i], nums[i]);
			num += n;
			System.err.println(n + "��" + moneys[i]);
			money -= moneys[i] * n;
		}
		return num;
	}
	
}
