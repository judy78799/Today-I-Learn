package D20240607;

public class OverloadDemo {

	public static void main(String[] args) {
		//메서드 오버로딩: 메서드 이름이 같고, 매개변수의 개수나 타입이 다른 경우
		System.out.println(max(100,200));
		System.out.println(max(7.5,8.3));
		System.out.println(max(7.5,8));
		System.out.println(max(10,50,20));
	}
	
	//int 일때
	static int max(int num1,int num2) {
		if(num1 > num2) {
			return num1;
		}else {
			return num2;
		}
	}
	
	//double 일때
	static double max(double num1, double num2) {
		
		double result = (num1 > num2) ? num1 : num2;
		return result;
	}
	
	
	static int max(int num1, int num2, int num3) {
		
		if(num1 > num2) {
			
			if(num1 > num3) {
				return num1;
			}else {
				return num3;
			}
			//num2가 클 떄
		}else {
			
			if(num2 > num3) {
				return num2;
			}else {
				return num3;
			}
//			return max(max(num1, num2), num3);
		}
		
		
	}

}
