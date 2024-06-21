package com.keduit;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

//Carconsumer Carpredicate 인터페이스를 쓰지 않아도 함수형 인터페이스를 사용해서 간단하게 구현이 가능하다.
public class Function2Demo {

	public static void main(String[] args) {

		//getModel을 가져와서 스트링으로 바꿔줌
		Function<_17_Car, String> f1 = c -> c.getModel();
		ToIntFunction<_17_Car> f2 = c -> c.getAge();
		
		//_17_Car.cars 의 리스트 요소들이 _17_Car 타입의 car 변수안에 넣어진다. 
		//모델과 연식만 출력함.
		for( _17_Car car : _17_Car.cars)
			System.out.println("( " + f1.apply(car) + ", " + f2.applyAsInt(car) + ") ");
		System.out.println();
		
		//람다식으로 구현체를 넣어준다. getAge getMileage
		double averageAge = average(_17_Car.cars, c -> c.getAge());
		double averageMileage = average(_17_Car.cars, c -> c.getMileage());
		
		System.out.println("평균 연식 = " + averageAge);
		System.out.println("평균 주행거리 = " + averageMileage);
	}
	
	
	static public double average(List<_17_Car> cars, ToIntFunction<_17_Car> f) {
		double sum = 0.0;
		
		for(_17_Car car: cars)
			//getAge getMileage
			sum += f.applyAsInt(car);
		
		return sum / cars.size();
	}

}
