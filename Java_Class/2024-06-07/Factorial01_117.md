package Practice;

import java.util.Scanner;

public class Factorial01_117 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		//키보드로 입력한 정수의 팩토리얼 값을 구하는 프로그램
		
//		int result;
//		int n;
//		Scanner in = new Scanner(System.in);
//		//키보드로 정수를 입력 받고 팩토리얼 값을 계산하는 코드
//		
//		
//		
//		System.out.println("하나의 정수를 입력하세요 : " );
//		n = in.nextInt();
//		
//		result = 1;
//		
//		while(n > 0) {
//			
//			result *= n--;
//			
//			//1이면 곱하나 마나기 때문에 1이면 브레이크/
//			if(n == 1) {
//				break;
//			}
//		}
//		System.out.println(result);
//		
		//조건문을 사용해 팩토리얼 값을 계산하는 코드.

		factorial(3);
		factorial(4);
		factorial(5);
		factorial(6);

	}
	
	
	//메서드를 사용한 정수의 팩토리얼 값을 구하는 프로그램
	static int factorial(int x) {
		//0이면 곱하기할 때 모두 0으로 나오기 때문에
		int r = 1;
		
		
		while(x > 0) {
					
					r *= x--;
					
					//1이면 곱하나 마나기 때문에 1이면 브레이크/
//					if(x == 1) {
//						break;
//					}
				}
				System.out.println(r);
		

		return r;
	}

}
