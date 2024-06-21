package com.keduit;

import java.util.function.IntBinaryOperator;

public class _13_CalculatorDemo {

	public static void main(String[] args) {

		//IntBinaryOperator: 메소드 두개를 가질 수 잇는 변수..?
		IntBinaryOperator operator;
		
		
		//정적 메소드 참조(클래스 명::스테틱명)
		operator = (x, y) -> _12_Calculator.saticMethod(x,y);
		System.out.println("결과 1 : " + operator.applyAsInt(7, 2));
		
		//축약형
		operator = _12_Calculator::saticMethod;
		System.out.println("결과 2 : " + operator.applyAsInt(8, 2));
		
		
		
		//인스턴스 메소드 참조(참조변수 명::메소드명) -> 인스턴스 변수가 필요함 new 해주기
		//static은 그냥 사용해도 되지만 일반 인스턴스 메소드는 
		_12_Calculator calc = new _12_Calculator();
		operator = (x,y) -> calc.instanceMethod(x, y);
		System.out.println("결과 3: " + operator.applyAsInt(5, 6));
		
		
		operator = calc::instanceMethod;
		System.out.println("결과 4 : " + operator);
	}

}
