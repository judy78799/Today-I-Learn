```
public class PersonDemo {

	public static void main(String[] args) {

		//p1은 Person 타입임.
		Person p1 = new Person(); //인스턴스
		
//		System.out.println(p1); //인스턴스 주소 반환
//		//p1안에 toString 메서드가 숨어있움 (p1 .해보면 나옴.)
//		System.out.println(p1.setName("홍길동"));  //인스턴스 주소 반환
//		System.out.println(p1.setAge(25));	//인스턴스 주소 반환 -> Person이니까
		p1.sayHello();
		
		p1.setName("한정교");
		p1.setAge(25);
		p1.sayHello();
		//***********************************
		//p1이 return Person하기 때문에,
		//p1.setName().setAge().sayHello() 가 가능함. 모두 같은 Person 객체를 반환함
		//Person을 리턴할 수 있는 이유: 인스턴스 객체이기 때문

		
		p1.setName("한정교").setAge(25).sayHello();


	};
	

}
```
