package com.keduit;


//빵틀1
interface NewObject<T>{
	T getObject(T o);
}
//빵틀2
interface NewArray<T>{
	T[] getArray(int size);
}


//람다 표현식과 메서드 참조방식
public class _15_ConstructorRefDemo {

	public static void main(String[] args) {

		// NewObject라는 제네릭 클래스를 선언, 이 클래스의 타입 매개변수를 String으로 지정한 객체 s를 선언합니다. 
		//즉, NewObject 클래스는 제네릭 클래스이고, s는 String 타입을 다루는 NewObject 객체입니다.
		NewObject<String> s;	//String 타입만
		NewArray<Integer> n;	//Integer 타입만
		
		//변수 s를 통해 문자열을 생성하는 기능을 제공.
		//String 타입을 받을 s는 x변수에 새로운 String 객체를 생성
		//해당 람다 표현식을 변수 s에 할당.
		
		//s는 x라는 매개변수를 가지고 새롭게 String 객체에 x를 생성한다.
		s = x -> new String(x);
		//참조를 사용하여 문자열을 생성하는 방법
		s = String::new;
		
		System.out.println(s.getObject("사과"));
		
		//n은 x를 매개변수로 가지는데 Integer객체에 새롭게 x 배열을 생성한다.
		n = x -> new Integer[x];
		n = Integer[]::new;
		
		//Integer 객체의 array는 
		Integer[] array = n.getArray(2);
		array[0] = 100;
		array[1] = 200;

//		System.out.println(array); 주소값만 나옴
		
		for(int i : array)
			System.out.println(i);

	}

}
