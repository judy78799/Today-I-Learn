package com.keduit;

import java.util.Arrays;
import java.util.List;

public class _17_Car {
	
	
	private String model;		//모델
	private boolean gasoline;	//휘발유 여부
	private int age;			//연식
	private int mileage;		//주행거리
	
	//getter
	
	public String getModel() {
		return model;
	}
	
	public boolean isGasoline() {
		return gasoline;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getMileage() {
		return mileage;
	}
	
	//toString
	public String toString() {
		return String.format("Car(%s,%s,%d,%d)", model, gasoline, age, mileage);
	}
	
	
	_17_Car(String model,boolean gasoline,int age,int mileage){
		
		this.model = model;
		this.gasoline = gasoline;
		this.age = age;
		this.mileage = mileage;
	}
	public static final List<_17_Car> cars = Arrays.asList(
			
			new _17_Car("소나타", true, 18, 210000),
			new _17_Car("코란도", false, 15, 200000),
            new _17_Car("그랜저", true, 12, 150000),
            new _17_Car("싼타페", false, 10, 220000),
            new _17_Car("에쿠스", true, 6, 100000),
            new _17_Car("그랜저", true, 5, 80000),
            new _17_Car("소나타", true, 2, 35000),
            new _17_Car("쏘렌토", false,10, 10000),
            new _17_Car("아반테", true, 1, 7000) 
            );	

}



