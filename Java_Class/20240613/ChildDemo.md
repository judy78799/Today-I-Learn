public class ChildDemo {

	public static void main(String[] args) {
		Child child = new Child();
		//child 상속받았기 때문에 자동 형변환이 일어난다.
		Parent parent = child;   //(Parent)child


		parent.method2();
		parent.method1();
//		parent.method3(); //Parent타입이므로 Child의 멤버에는 접근 불가
	}

}
