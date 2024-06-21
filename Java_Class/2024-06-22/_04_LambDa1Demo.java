package com.keduit;

import java.util.Arrays;
import java.util.Comparator;


//객체 비교 예제
//람다식으로 바꿈
public class _04_LambDa1Demo {

	public static void main(String[] args) {

		String[] strings = {"로마에 가면 로마법을 따라라",
							"시간은 금이다",
							"펜은 칼보다 강하다"};
		
		//익명 구현 객체를 람다식으로 바꿈
		//람다식: 
		//strings라는 배열을 꺼내올 건데 람다식으로 꺼내줘
		//일반 스트링은 가나다순으로 배열이됨.
		//하지만 스트링 글자 크기로 비교하고 싶음. -> 
		//문자열의 길이에 따라 오름차순으로 정렬.
		Arrays.sort(strings, (o1,o2) -> o1.length() - o2.length());
		

		//스트링 타입의 s변수안에 string 배열을 출력해줘
		for(String s : strings) {
			System.out.println(s);
		}
		

	}

}
