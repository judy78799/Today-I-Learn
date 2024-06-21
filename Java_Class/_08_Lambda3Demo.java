package com.keduit;



interface Printable {
	
	void print();
}


interface Negative{
	int neg(int x);
}


public class _08_Lambda3Demo {

	
	public static void main(String[] args) {

		Negative n;
		
		//람다식: (매개변수) -> {실행문; 실행문; ..}
		n = (int a) -> {return - a;};
		
		//매개변수의 타입은 추론이 가능하므로 생략가능
		n = (a) -> {return -a;};
		
		//매개변수가 한 개이면 () 생략 가능
		n = a -> {return -a;};
		
		//실행문이 한 개이면 중괄호와 세미콜론 생략가능. 단! 리턴문이 있으면 {} 생략 불가.
		n = a -> {return -a;};
		
		System.out.println(n.neg(150));
		
		
		Printable p;
		
		//인터페이스를 람다로 구현함. -> 호출 안하면 소용없음.
		//실행문이 하나이고 return 문이 아닌 경우,  {}와 ; 생략 가능
		p = () -> System.out.println("안녕!");
		
		p.print();
		
		

	}

}
