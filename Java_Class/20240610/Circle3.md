```

public class Circle3 {
	double radius;
	String color;
	
	
	//this() : ()안에 다른 생성자를 호출함.
	public Circle3(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}
	
	public Circle3(double radius) {
		this(radius, "파랑"); //다른 생성자가 "파랑"
	}
	
	public Circle3(String color) {
		this(10.0, color); //다른 생성자가 10.0
	}
	
	public Circle3() {
		this(20.0, "노랑");
	}
	
	
	//*******************************
	//this가 위에 먼저 선언되어야 함
  //	public Circle3() {
  //		this("노랑");
  //		this.radius = 20.0;
  //	}
	//*******************************
	
	//디폴트 생성자와 마찬가지로 toString() '재정의' 하여 해당 메서드가 출력되는 것이다.
	//toString 메서드는 c1안에 포함되어 있음.
	public String toString() {
		return "반지름이 " + radius + "인 " + color + " 원";
	}
}

```
