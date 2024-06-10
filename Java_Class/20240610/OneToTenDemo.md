```

public class OneToTenDemo {

	static int sumOneToTen;
	int age = 25;
	
	static {
		int sum = 0;
		for(int i=1; i<= 10; i++) sum += i;
		sumOneToTen = sum;
	}
	public static void main(String[] args) {
		
		//스테틱 변수, 스태틱 메소드, 스테틱 블록은 인스턴스를 생성하지 않고도 사용이 가능하다.
		System.out.println(sumOneToTen);
		
		//static이 아닌 애들은 new로 만들어줘야 함. 공유가 안되기 때문.
		OneToTenDemo o1 = new OneToTenDemo();
		//클래스의 멤버변수 중 static이 아닌 것은 인스턴스를 생성해야 사용이 가능하다.
		System.out.println(o1.age);
	}

}

```
