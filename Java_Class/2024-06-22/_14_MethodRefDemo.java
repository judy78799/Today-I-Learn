package com.keduit;

@FunctionalInterface
interface Mathematical{
	double calculate(double d);
}

@FunctionalInterface
interface Pickable{
	char pick(String s, int i);
}

@FunctionalInterface
interface Computable{
	int compute(int x, int y);
}


class Utils{
	int add(int a,int b) {
		return a + b;
	}
}


public class _14_MethodRefDemo {

	public static void main(String[] args) {

		Mathematical m;
		Pickable p;
		Computable c;
		

		m = d -> Math.abs(d);	//람다식
		System.out.println(m.calculate(8));	//static 메소드 참조
		m = Math::abs;
		
		
		p = (a,b) -> a.charAt(b);
		//a의 타입이 String
		p = String::charAt;
		System.out.println(p.pick("헛소리하지마 임마", 5));
		
		
		//고차원적인 방법..!
		//클래스이기 때문에 new 해서 불러와줌
		Utils utils = new Utils();
		
		c = (a,b) -> utils.add(a, b);
		c = utils::add;
		System.out.println(c.compute(20, 30));
		
		
		

	}

}
