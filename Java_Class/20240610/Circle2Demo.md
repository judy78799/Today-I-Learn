```
public class Circle2Demo {

	public static void main(String[] args) {
		
		//디폴트 생성자
		//매개변수가 있는 생성자를 기술할 경우, 컴파일러는 디폴트 생성자를 만들지 않는다.
		//매개변수가 없는 생성자가 있는 경우에는 반드시 디폴트 생성자를 선언해줘야 할당이 가능.
		//Circle2 파일의 public Circle2(){}라는 디폴트 생성자를 선언해줘야 할당이 가능.(오버로딩)

		Circle2 c1 = new Circle2();	//디폴트 생성자
		
		
		Circle2 c2 = new Circle2(20.0);
		Circle2 c3 = new Circle2("빨강");
		Circle2 c4 = new Circle2(15.0, "파랑");
		System.out.println(c1);	//객체 주소 반환, 다 다른 값 반환함. 각기 다른 인스턴스이기 때문에.
		System.out.println(c2);	//객체 주소 반환
		System.out.println(c3);	//객체 주소 반환
		System.out.println(c4);	//객체 주소 반환
		
		System.out.println(c1.getColor() + "," + c1.getRadius());	
		System.out.println(c2.getColor() + "," + c2.getRadius());
		System.out.println(c3.getColor() + "," + c3.getRadius());
		System.out.println(c4.getColor() + "," + c4.getRadius());

	}

}
```
