package com.keduit;

import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.function.ToDoubleBiFunction;

public class Function1Demo {

	public static void main(String[] args) {

		//Integer를 넣으면 Integer를 반환해줌
		Function<Integer, Integer> add2 = x -> x + 2;
		Function<Integer, Integer> mul2 = x -> x * 2;
		
		//타입 에러 andThen메서드 불가: Integer
		Function<Integer, Double> add3 = x -> x + 2.0;
		Function<Integer, Integer> mul3 = x -> x * 2;
		
		
		System.out.println(add2.apply(3)); //5
		System.out.println(add2.andThen(mul2).apply(3)); //10
		//compose() 반대로 해줘 1. mul2 2. add2
		System.out.println(add2.compose(mul2).apply(3));	//8
		
		IntToDoubleFunction half = x -> x / 2.0;
		System.out.println(half.applyAsDouble(5));	//2.5?
		
		ToDoubleBiFunction<String, Integer> circleArea = (s, i)
			//string을 double로 바꿔줌
			-> Double.parseDouble(s) * i * i;
			double area = circleArea.applyAsDouble("3.14" , 5); //3.14 * 5* 5
			System.out.println(area);

	}

}
