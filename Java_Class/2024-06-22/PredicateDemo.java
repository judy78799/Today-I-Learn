package com.keduit;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

//Java의 함수형 인터페이스 IntPredicate 사용예제
public class PredicateDemo {

	public static void main(String[] args) {

		//IntPredicate는 Java의 함수형 인터페이스로, int 값을 받아서 boolean 값을 반환하는 함수형 인터페이스입니다.
		//one.or(even)은 두 개의 IntPredicate를 결합하는 방식입니다.
		// 이 결합은 논리적인 OR 연산을 의미합니다. 즉, 두 조건 중 하나라도 참이면 결과적으로 참이 됩니다.
		
		//IntPredicate 선언:
		IntPredicate even = x -> x % 2 == 0;
		System.out.println(even.test(3) ? "짝수" : "홀수");
		
		IntPredicate one = x -> x == 1;
		IntPredicate oneOrEven = one.or(even);
		System.out.println(oneOrEven.test(1) ? "1혹은 짝수" : "1이 아닌 홀수");
		
		Predicate<String> p = Predicate.isEqual("Java Lambda");
		System.out.println(p.test("Java Lambda"));
		System.out.println(p.test("JavaFX"));
		
		
		BiPredicate<Integer, Integer> bp = (x,y) -> x > y;
		System.out.println(bp.test(2, 3));
		

		
		
		List<Integer> list = Arrays.asList(1,5,6,3,2,8,9,10);
		int total = 0;
		
		
		//Predicate<Integer> p 여기에 적용할 식(조건문)을 넣어준다.
		//짝수의 합
		// x -> x % 2 == 0 이게 참이되는 식 (p.test(i))
		total = sum ( x -> x % 2 == 0 , list);
		System.out.println("짝수의 합 : "+ total);
		
		//홀수의 합
		total = sum ( x -> x % 2 == 1 , list);
		System.out.println("홀수의 합 : " + total);
		
		//3의 배수의 합
		total = sum ( x -> x % 3 == 0 , list);
		
		//x가 6보다 작으면 합
		total = sum ( x -> x < 6, list);
		
	}
	
	
	//조건과 데이터를 주면 조건에 맞는 수의 합을 구하는 메소드
	static int sum(Predicate<Integer> p, List<Integer> list) {
		
		int sum = 0;

		//먼저 list에 있는 것들을 모두 꺼내온다.
		for(int i : list)
			//Predicate<Integer> p 안의 test()는 boolean을 반환시켜준다.
			//이 안에 있는 것이 참이라면~~sum에 i 값을 넣어줘
			if(p.test(i)) {
				sum += i;
			}
		
		return sum;
		
	}
	


}
