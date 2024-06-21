package com.keduit;

public class _11_CalculateDemo {

	public static void main(String[] args) {

		// 람다식: ci라는 변수에 x y를 넣고 x + y해줘
		_10_Calculate<Integer> ci = (x, y) -> x + y;
		System.out.println(ci.cal(5, 50));
		
		// 람다식: cd라는 변수에 x y 를 넣고 x * y해줘
		_10_Calculate<Double> cd = (x,y) -> x * y;
		System.out.println(cd.cal(10.1, 5.0));

	}

}
