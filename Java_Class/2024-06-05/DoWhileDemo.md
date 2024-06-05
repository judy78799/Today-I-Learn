package D20240605;

public class DoWhileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//i * j
		int i = 1;
		int j = 1;
		
		do {
			
			i++; //2
			j = 1;
			
			do {
				//여기 안에서 하나의 구구단 가로줄이 완성된다.
				System.out.print(i * j + "\t"); //2
				j++;
				
			} while (j < 10);
			//i++ 3의 배수가 되는 부분.
			System.out.print("\n"); //
			
		} while (i < 10);
			
			
		
	
	}
}
