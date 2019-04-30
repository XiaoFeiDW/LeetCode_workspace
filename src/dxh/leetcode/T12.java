package dxh.leetcode;

public class T12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int num = 1;
//		String str = intToRoman1(num);
//		System.err.println(str);
		RomanRadix[] values = RomanRadix.values();
		for(int i = 0; i < values.length; i++) {
			System.err.println(values[i].getValue());
			System.err.println(values[i].name());
		}
		
	}
	
	//此方法占用很大的内存，而且时间也挺长
	public static String intToRoman1(int num) {
		
		if(num < 1 || num > 3999) {
			return null;
		}
		
		String romans = "";
		int i = String.valueOf(num).length();
		int num1 = 0;
		while(num != 0) {
			int n;
			n = num / (int)(Math.pow(10, i - 1));
			num1 = n * (int)(Math.pow(10, i - 1));
			i--;
			num -= num1;
			romans += integerToRoman(num1, n);
			
		}
		
		return romans;
	}

	public static String integerToRoman(int num, int n) {
		String str = "";
		
		if(num >= 1000) {
			for(int i = 0; i < n; i++) {
				str += 'M';
			}
		}else if(num == 900) {
			str += "CM";
		}else if(num < 900 && num >= 500){
			str += 'D';
			for(int i = 0; i < n - 5; i++) {
				str += 'C';
			}
		}else if(num == 400) {
			str += "CD";
		}else if(num < 400 && num >= 100) {
			for(int i = 0; i < n; i++) {
				str += 'C';
			}
		}else if(num == 90) {
			str += "XC";
		}else if(num < 90 && num >= 50) {
			str += 'L';
			for(int i = 0; i < n - 5; i++) {
				str += 'X';
			}
		}else if(num == 40) {
			str += "XL";
		}else if(num < 40 && num >= 10) {
			for(int i = 0; i < n; i++) {
				str += 'X';
			}
		}else if(num == 9) {
			str += "IX";
		}else if(num < 9 && num >= 5) {
			str += 'V';
			for(int i = 0; i < n - 5; i++) {
				str += 'I';
			}
		}else if(num == 4) {
			str += "IV";
		}else {
			for(int i = 0; i < n; i++) {
				str += 'I';
			}
		}
		
		return str;
	}

	//基于枚举的写法
	public static String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		RomanRadix[] values = RomanRadix.values();
		for(int i = 0; i < values.length; i++) {
			int quotient = num / values[i].getValue();
			num = num % values[i].getValue();
			for(int j = 0; j < quotient; j++) {
				sb.append(values[i].name());
			}
		}
		
		return sb.toString();
	}
	
	enum RomanRadix{
		M(1000),
		CM(900),
		D(500),
		CD(400),
		C(100),
		XC(90),
		L(50),
		XL(40),
		X(10),
		IX(9),
		V(5),
		IV(4),
		I(1);
		
		private int value;
		private RomanRadix(int value) {
			this.value = value;
		}
		public int getValue() {
			return value;
		}
	}
}
