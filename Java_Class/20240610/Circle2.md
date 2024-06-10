public class Circle2 {
	
	private double radius;
	private String color;
	
	public Circle2(){} //디폴트 생성자 
	
	//인스턴스 4개
	public Circle2(double radius, String color) {
		this.radius = radius;
		this.color = color; 
	}
	
	public Circle2(double radius) {
		this.radius = radius;
		this.color = "노랑";
	}
	
	public Circle2(String color) {
		this.radius = 10.0;
		this.color = color;
	}
	
	//radius와 color의 값을 반환하는 getter(getCircle())를 작성해보자.
	//getRadius()
	public double getRadius() {
		return radius;
	}
 
	//getColor()
	public String getColor() {
		return color;
	}
	
}
