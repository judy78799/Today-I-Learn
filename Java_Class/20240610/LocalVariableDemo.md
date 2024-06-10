

public class LocalVariableDemo {
	
	static int result;	//필드: 초기화를 줘도 되고 안줘도 됨(알아서 초기화를 시켜줌.)/ 클래스 안에서 선언된 변수.
	

	public static void main(String[] args) {
		
		//지역변수  : 메소드 내에서 선언된 변수.
		//필드(멤버변수): 클래스에서 선언된 변수.
		
		System.out.println(result);	//필드는 초기값이 있어서 초기화 하지 않고도 사용가능
		
		
		int a = 0;
		double b;
		
//		System.out.println(b); // 초기화 되지 않았음
		
//		System.out.println(c);  //출력 후에 변수를 선언함. //선언하지 않은 지역변수를 사용하면 error
		
//		int c = 0;
		
//		public double d = 0.0;	//지역변수는 접근 지정자(public)를 쓸 수 없다.
		
//		for(int i = 0; i<10; i++) {
//			System.out.println(i);
//			int a = 10;	//같은 메소드 내에서는 변수의 이름을 다르게 지정해야 한다.
//		}
	}

}
