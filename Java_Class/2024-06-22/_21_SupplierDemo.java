package com.keduit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class _21_SupplierDemo {

	public static void main(String[] args) {

		Supplier<String> s1 = () -> "apple";
		System.out.println(s1.get());
		
		//배열인 이유: 안에 주소값이 있어서?
		//x배열에 0을 넣는다.
		int[] x = {0};
		//IntSupplier 함수 인터페이스 사용 해서 s2 변수 안에 x[0]++ 
		IntSupplier s2 = () -> x[0]++;
		//반복문 사용해서 IntSupplier 함수 인터페이스의 값을 꺼내오는 메서드 getAsInt를 사용한다,
		for(int i = 0; i < 3; i++) {
			System.out.println(s2.getAsInt());
		}
		
		//error
//		int x1 = 0;
		//final 이다.
//		s2 = () -> x1++;
		
	
		
		
		
		
		//DoubleSupplier 함수 인터페이스 사용 해서 s3 변수 안에 Math.random() * 10;
		DoubleSupplier s3 = () -> Math.random() * 10;
		//DoubleSupplier 함수 인터페이스 값을 꺼내 온다.
		System.out.println(s3.getAsDouble());
		
		
		//SimpleDateFormat 함수 인터페이스 사용해서 format이라는 변수에 새로운 객체를 생성해서 안에 매개변수를 넣어준다.
		SimpleDateFormat format = new SimpleDateFormat("MM월 dd일 (E요일) a hh:mm:ss");
		//format 변수의 format 안에 new Date 메서드를 넣어준다.
		Supplier<String> s4 = () -> format.format(new Date());
		System.out.println(s4.get());

	}

}
