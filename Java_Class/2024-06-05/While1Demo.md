package D20240605;

public class While1Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//조건문이 참인 동안 실행
//		int i = 1;
//		int j = 0;
//		
//		while(i < 9) { //세로열
//			
//			
//			i++;
//			j = 0;
//			
//			while(j < 9) { //가로열  0xj
//				j++; //2-10 꼭 있어야함
//				System.out.print(i * j + "\t");
//				
//			}
//			System.out.println();
//			
////			System.out.print(i * j + "\n"); //여기선 i가 9인 상태임 i는 9이고 j만 돌아감
//			
//		}	
//		
		
		int i = 1;
		do {
			System.out.println(i);
			i++;
			
		}while(i < 5);
	
	}
}
