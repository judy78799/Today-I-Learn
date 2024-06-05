package D20240605;


## break는 for문과 while문에서 사용이 가능하다.

public class BreakDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		
		while(true) {
			
			i++;
			
			//홀수라면~
			if(i%2 == 0) {

				continue;
				
			}if(i > 10) {
				
				break;
			}
			System.out.println(i);
		}

	}

}
