```
public class Circle4Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    // Circle4 c1 = new Circle4(); //error: Circle4()에는 매개변수를 갖는 생성자를 기술했으므로 디폴트 생성자는 자동으로 만들어지지 않는다.
		Circle4 c2 = new Circle4(10.0);
		Circle4 c3 = new Circle4(5.0);
		
		System.out.println("c2원의 번호 : "  + c2.numCircles);
		System.out.println("c3원의 번호 :" + c3.numCircles);
		System.out.println("원의 개수 : " + Circle4.numOfCircles);
	}

}
```
