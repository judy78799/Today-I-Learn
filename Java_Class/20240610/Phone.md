//지역변수 전역변수 차이점 



package com.keduit;

public class Phone {
    String model;   // default : null
    int value;      // default : 0
    
    void print() {
        int i = 10;  // 지역변수
        System.out.println(this.value + "만 원짜리 " + this.model + " 스마트 폰" + i);
    }
    
    void print(String model, int value) {
        this.model = model;
        this.value = value;
        print();
    }

}
