package com.keduit;

public class _07_Rambda2Demo {

	public static void main(String[] args) {

		//우리가 지금까지 사용한 방법: 인스턴스 뉴 생성해서 호출
//_06_Printer implements _05_Printable
		_05_Printable prn = new _06_Printer();
		//implements를 하게되면 자식이 부모의 메서드를 재정의 해야 함. 그럼 부모가 자식 메서드 가져온거임?
		prn.print("람다가 뭘까");
		
		
		// new _05_Printable() -> 익명 클래스를 사용해서 
		_05_Printable prn2 = new _05_Printable() {

			@Override
			public void print(String s) {
				System.out.println(s);
			}
			
		};
		
		//위에선 구현만 해준거고 출력을 해주어야 나타남.
		prn2.print("익명 클래스를 활용해서 출력");
		
		
		//람다를 활용해보자
		//메소드 잠깐 쓸 건데 
		_05_Printable prn3 = (s) -> {System.out.println(s);};
		prn3.print("이것이 람다다.");
		

	}

}
