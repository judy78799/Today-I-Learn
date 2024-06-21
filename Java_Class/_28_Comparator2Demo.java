package com.keduit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _28_Comparator2Demo {

	public static void main(String[] args) {

		//subList(0,3) : _17_Car.cars에서 0에서 2까지 꺼내오기.
		List<_17_Car> list = _17_Car.cars.subList(0,3);
		//list.toArray: 배열로 바뀜
		_17_Car[] cars = list.toArray(new _17_Car[4]);
		
		//비교 기준: 자동차의 모델을 기준으로 설정
		//Comparator 타입의 modelComparator
		Comparator<_17_Car> modelComparator = Comparator.comparing(_17_Car::getModel);
		
		// 기준(modelComparator)을 적용하기 전의 배열을 출력. -> new _17_Car[4] 에서 subList(0,3) 맨 마지막 배열은 Null로 남아있움.
		System.out.println(Arrays.toString(cars));
		
		//nullsFirst: null을 가장 작은 값으로 취급하는 Comparator를 생성하는 메소드.
		Comparator<_17_Car> modelComparatorNullsFirst
			= Comparator.nullsFirst(modelComparator);
		
		//cars 리스트를 modelComparatorNullsFirst 이 기준으로 sort해줘. -> null이 맨 앞으로 가 있을 것임.
		Arrays.sort(cars, modelComparatorNullsFirst);
		System.out.println(Arrays.toString(cars));
		
		//set의 2가 2번지에 코란도를 넣어줘
		//list.set(2 , new _17_Car()): 리스트의 2번 원소에 새로운 car 객체를 넣어줌(replace)
		list.set(2 , new _17_Car("코란도", false, 10, 220000));

		
		//배열 cars를 3개 짜리로 바꾸어 리스트에서 배열로 넣어줌.
		//주소를 바꾸어서 cars에 넣어준거임? 
		cars = list.toArray(new _17_Car[3]);
		System.out.println(Arrays.toString(cars));
		
		
		//기준 새로 추가
		//기존의 modelComparator에 기준점을(연식) 추가하여 modelNAgeComparator로 생성.
		Comparator<_17_Car> modelNAgeComparator 
			= modelComparator.thenComparing(_17_Car::getAge);
		
		//배열의 정렬기준으로 modelNAgeComparator를 적용함.
		Arrays.sort(cars, modelNAgeComparator);
		System.out.println(Arrays.toString(cars));

	}

}
