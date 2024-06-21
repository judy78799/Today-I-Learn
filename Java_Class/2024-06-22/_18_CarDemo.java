package com.keduit;

import java.util.ArrayList;
import java.util.List;

public class _18_CarDemo {

	public static void main(String[] args) {
		
		//디젤 자동차만 찾아보자 > CarPredicate 인터페이스를 사용하면 좋다.
		//_17_Car.cars 여기 안에 데이터가 다 있음.
		List<_17_Car> diselCars = findCars(_17_Car.cars, c->!c.isGasoline());
		System.out.println("디젤 자동차 = " + diselCars);
		

		//10년보다 오래된 자동차를 찾아보자.
//		printCars(diselCars, c -> System.out.println(c.getModel() + c.getAge()));
		//CarPredicate의 Boolean test 활용.
		List<_17_Car> year10Older = findCars(_17_Car.cars, c-> c.getAge() > 10);
		System.out.println("year10Older 자동차 = " + year10Older);
		
		
		
		//10년보다 오래된 디젤 자동차를 찾아보자.
		//!c.isGasoline() && c.getAge() > 10
		List<_17_Car> disel10Older = findCars(_17_Car.cars, c-> !c.isGasoline() && c.getAge() > 10);
		System.out.println("10년보다 오래된 디젤 자동차 = " + disel10Older);
		
		
		//10년보다 오래된 자동차를 출력하되 모델, 연식, 주행거리만 나타내고 출력하자.
		printCars(year10Older, c -> System.out.println("[10년보다 오래된 자동차: 모델, 연식, 주행거리] : "+ c.getModel() + " , " + c.getAge()+ " / "+ c.getMileage()+ " / "));
		
		
		// 디젤 자동차를 출력하되 모델과 연식만 나타내도록 하자.
		//CarConsumer가 void 타입을 반환하기 때문에 sysout을 써줘야 한다.
		printCars(diselCars, c -> System.out.println(c.getModel() + "," + c.getAge()+ " / "));

	}

	//코드가 간결해짐
	//findCars 메서드 -> 조건에 따라 다양한 것을 출력해줌
	//CarPredicate 인터페이스의 cp변수 안에 위의 람다식이 들어가서 결과를 다양하게 출력해줌
	public static List<_17_Car> findCars(List<_17_Car> all, CarPredicate cp){
		
		//빈 리스트 초기화
		List<_17_Car> result = new ArrayList<_17_Car>();
		
		//_17_Car 타입의 car라는 변수에 리스트 값을 모두 넣어줌
		for(_17_Car car : all) {
			// !c.isGasoline()
			//CarPredicate 안의 메서드 test
			//조건만 잘 주면 그에 맞는 결과를 찾아줌
			
			//만약 cp안에 있는 메서드 test가 true라면~
			if (cp.test(car) == true) {
				//빈 배열에 car를 담아줘
				result.add(car);
			}
		}
		return result;
	}
	
	//CarConsumer 안의 cc 변수 안의 accept 메서드 호출됨.
	public static void printCars(List<_17_Car> all, CarConsumer cc) {
		for(_17_Car car : all) {
			cc.accept(car);
		}
	}

}
