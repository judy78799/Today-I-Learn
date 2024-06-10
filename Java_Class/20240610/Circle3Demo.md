```

public class Circle3Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle3 c1 = new Circle3();
		Circle3 c2 = new Circle3(15.0);
		Circle3 c3 = new Circle3("빨강");
		Circle3 c4 = new Circle3(10.0,"그린");
		
		
		//원래 주소값을 출력함
		//but, Circle Java의 toString()를 선언하게 되면,
		//c1+. 하게되면 그 안에 toString이 숨겨져 있음.
		//그 안의 toString을 재정의 해준 것임.
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
	}

}
```
