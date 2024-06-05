package D20240605;

import java.util.Scanner;

public class NestedIfDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		
		String grade = ""; 
		
		if(x >= 90) {
			grade = "A+";
		}else {
			grade = "A0 or A-";
		}
		
		System.out.println(grade);
	}

}
