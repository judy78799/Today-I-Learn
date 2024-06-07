package D20240607;

public class EchoDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Echo("안녕", 3);
			//Echo("안녕"); //메소드를 호출 시 매개변수의 개수만큼 인수를 주어야 한다.
			echo("Hello");
			echo('*', 10);
	}
	
	static void Echo(String message, int num) {
		for(int i = 0; i < num; i++) {
			System.out.println(message);
		}
		
	}
	
	static void echo(String message) {
		System.out.println(message);
	}
	
	//메서드 이름은 같지만 메서드 시그니처가 다른 메서드를 정의하는 것을 오버로딩이라고 한다.
	static void echo(char message, int count) {
		for(int i = 0; i < count; i++) {
			System.out.println(message);
		}
		System.out.println();
		
	}

}
