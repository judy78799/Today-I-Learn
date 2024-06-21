package com.keduit;

import java.util.Comparator;

interface UseThis{
	void use();
}

public class _16_UseThisDemo {

	public static void main(String[] args) {

		int one = 1;
		//static이 아니기 때문에 new 해서 만들어줌.
		//자바에서 static 키워드는 클래스 수준에서 접근 가능한 멤버(필드나 메서드)를 정의할 때 사용됩니다. static 멤버는 클래스의 인스턴스 없이도 접근할 수 있습니다. 
		//반면, static이 아닌 멤버는 클래스의 인스턴스를 생성해야만 접근할 수 있습니다.
		new _16_UseThisDemo().lambda();
		//람다식의 선언부 매개변수 이름은 지역변수와 겹치지 않게 지정해야 한다.
//		Comparator<String> c = (one,two) -> one.length() - two.length();
		//Comparator 인터페이스: 메서드 2개로 객체 비교해주는 것
		Comparator<String> c = (first,two) -> first.length() - two.length();
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "나, _16_UseThisDemo() 임.";
	}


	private void lambda() {

		String hi = "Hi";	// 지역변수 특징: 1. 초기화 해주어야 함.
		//익명 지역 객체 바깥의 지역변수 hi
		
		//익명 지역 객체
		UseThis u1 = new UseThis() {

			@Override
			public void use() {
				System.out.println(this);
				System.out.println(hi);
//				hi = hi + "Lambda";	//익명 지역 객체 바깥의 지역 변수는 final이므로 값 변경이 불가함.
			}
		};
		//u1으로 만든 지역객체를 실행.
		u1.use();
		
		//u1 을 람다식으로 구현한 것임.
		UseThis u2 = () -> {
			System.out.println(this);
			System.out.println(hi);
//			hi = hi + "Lambda";
			};
			
		u2.use();
		
	}

}
