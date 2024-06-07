package D20240607;

public class Switch1Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 4;
		
		switch(number) {
			case 4 : 
				System.out.print("*"); break; //switch문을 빠져 나간다.
			case 3 : 
				System.out.print("*"); 
			case 2 : 
				System.out.print("*"); 
			case 1 : 
				System.out.print("*"); 
			default: 
				System.out.println("**");	// break문이 없으면 흘러내린다.
		}
	}

}
