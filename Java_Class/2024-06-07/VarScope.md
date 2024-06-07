package D20240607;

public class VarScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean ste = true;
		int num = 11;
		
		
		if(ste) {
//			int num = 10; //변수를 if블럭 안에서 중복 선언할 수 없다.
			num++;
			System.out.println(num);
		}
		
		
		
		{
			int num2 = 33;
			num2 ++;
			System.out.println(num2);
		}
		
//		System.out.println(num2);   //{}블럭 안에서 선언한 변수는 블럭 밖에서 사용할 수 없다.
		
		
	}

}
