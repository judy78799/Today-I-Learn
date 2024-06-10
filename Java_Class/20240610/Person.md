```

public class Person {
	String name;
	int age;
	
	
	//setName메서드는 String name을 받아서
	//Person의 name 변수에 넣어준다.
	public Person setName(String name) {
		this.name = name;
		return this; //Person 클래스를 반환
	}
	
	public Person setAge(int age) {
		this.age = age;
		return this; //Person 클래스를 반환
	}
	
	public String toString() {
		return "name :" + name + " 나이 :" + age; //this.name this.age 생략된 것임.
	}
	
	public void sayHello() {
		System.out.println("안녕, 나는 " + name + "이고 " + age + "살이야.");
	}
	
}
```
