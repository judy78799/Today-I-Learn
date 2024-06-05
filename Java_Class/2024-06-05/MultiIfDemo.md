package D20240605;

import java.util.Scanner;

public class MultiIfDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
//		System.out.println("학점을 입력해주세요 : " + x);
		int x = in.nextInt();
		
		
		if(  100 >= x || x >= 95 ) {
			System.out.println("당신의 학점은 A");
		}else if(95 > x || x > 85){
			System.out.println("당신의 학점은 B");
		}else if(x > 75){
			System.out.println("당신의 학점은 C");
		}else {
			System.out.println("당신의 학점 Out");
		}
	}

}
