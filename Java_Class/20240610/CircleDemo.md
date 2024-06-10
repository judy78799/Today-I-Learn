```
public class CircleDemo {

	public static void main(String[] args) {
		Circle myCircle = new Circle(); //참조변수 myCircle: 참조변수
		
		//초기화 되기 전
		//Circle 클래스의 필드 radius의 접근 제한자가 
//		System.out.println(myCircle.radius); //0.0 멤버변수: 값을 따로 안줘도 초기화가 된다.
//		myCircle.radius = 10.0;
//		System.out.println(myCircle.radius);
//		System.out.println(myCircle.radius(), myCircle.findArea());
//		myCircle.show(myCircle.radius, myCircle.findArea());
		

		//circle클래스의 필드 radius의 접근 제한자를 private으로 선언하여
		//radius를 은닉하고 Circle 클래스를 캡슐화함.
		System.out.println(myCircle.getRadius()); //10.0 
		myCircle.setRadius(10.0);
		System.out.println(myCircle.getRadius());
		myCircle.show(myCircle.getRadius(),myCircle.findArea());
		
	}

}
```
