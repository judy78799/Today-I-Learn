package com.keduit;

import java.util.Arrays;
import java.util.Comparator;


//객체 비교 예제
public class _03_ComparatorDemo {

	public static void main(String[] args) {

		String[] strings = {"로마에 가면 로마법을 따라라",
							"시간은 금이다",
							"펜은 칼보다 강하다"};
		
		//익명 구현 객체: 이름은 없지만 오버라이드 해서 사용함.
		//new Comparator: 정렬 기준 제시
		Arrays.sort(strings, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		
		for(String s : strings) {
			System.out.println(s);
		}
		

	}

}
