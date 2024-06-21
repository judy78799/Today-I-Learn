package com.keduit;

import java.util.Arrays;

public class _02_RectangleDemo {

	public static void main(String[] args) {

		_01_Rectangle[] recs = {
				new _01_Rectangle(5,5),
				new _01_Rectangle(5,10),
				new _01_Rectangle(10,3),
		};
		
		//객체인데 비교할 기준이 없다, ==> error _01_Rectangle
		Arrays.sort(recs);
		
		for(_01_Rectangle rec : recs) {
			System.out.println(rec);
		}

	}

	

}
