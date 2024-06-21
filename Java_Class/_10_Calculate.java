package com.keduit;


// 함수형 인터페이스 : 추상 메소드가 한 개뿐인 인터페이스 
@FunctionalInterface
interface _10_Calculate<T> {
	//T타입의 cal 안에 매개변수 두개를 넣어줌
	T cal(T a, T b);
	
	//인터페이스는 함수가 아님.
	//	void say();

}
