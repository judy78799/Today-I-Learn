public class Car extends Vehicle{
	
	String name = "자동차";
	
	@Override
	void WhoamI() {
		System.out.println("나는 자동차 입니다.");
	}
	
	//static이라서 override가 안된다.
	static void move() {
		System.out.println("달립니다.");
	}
}
