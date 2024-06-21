package com.keduit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//거꾸로 뒤집기 for
public class _27_Comparator1Demo {

	public static void main(String[] args) {

		List<_17_Car> list = _17_Car.cars.subList(0, 3);
		System.out.println(list);
		_17_Car[] cars = list.toArray(new _17_Car[3]);
		
		
		//Array.toString() 사용하면 for문 사용 안해도 됨.
		for(_17_Car car : cars) {
			System.out.println(car);
		}
		
		//비교기준 modelComparator 모델을 기준으로 sort해라
		Comparator<_17_Car> modelComparator = Comparator.comparing(_17_Car::getModel);
		Arrays.sort(cars,modelComparator);
		Arrays.toString(cars);
		
		//for문으로 돌리는 것 보다 Arrays.toString()이 배열을 꺼내볼 때 훨씬 수월함.
		System.out.println(Arrays.toString(cars));
		
		//거꾸로 뒤집기  1. reversed() 사용.=====================================.
		Arrays.sort(cars, modelComparator.reversed());
		System.out.println(Arrays.toString(cars));

		//이제는 마일리지 순으로 소트해줘
		//여기엔 Comparator<_17_Car> modelComparator 이게 없으므로 modelComparator.reversed());이런 식으로 만들어줄 수 없다.
		Arrays.sort(cars, Comparator.comparing(_17_Car::getMileage));
		System.out.println(Arrays.toString(cars));
		
		
		//거꾸로 뒤집기  2. (a,b) -> b - a) 사용. ================================.
		//reverse 대신에 (a,b) -> b - a) 이걸루 거꾸로 만들어준다.
		Arrays.sort(cars, Comparator.comparing(_17_Car::getMileage, (a,b) -> b - a));
		System.out.println(Arrays.toString(cars));
	}

}
