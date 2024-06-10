```

public class Circle {

	private double radius; 		//private -> 필드를 은닉함.
//	double radius;		      //필드를 오픈함 -> 다른 클래스에서 값을 가져가거나 꺼내가는 것이 자유롭다.
	


		double findArea() {
			return 3.14 * radius * radius;
		}
		
		void show(double x, double y) {
			System.out.printf("반지름 = %.1f, 넓이 = %.1f\n", x, y);
		}
		
		//필드를 은닉한 경우 다른 클래스에서 이 클래스의 radius 필드의 값을 꺼내갈 수 있도록 접근자를 만들어줌. 
		//getter
		//장점: 보너스 포인트를 줄 수 있음.
		public double getRadius() {
			return radius;
		}
		
		//필드를 은닉한 경우 다른 클래스에서 이 클래스의 radius 필드의 값을 변경(지정)할 수 있도록 접근자를 만들어줌. 
		//setter
		public void setRadius(double radius) {
			this.radius = radius;
		}

	}


```
