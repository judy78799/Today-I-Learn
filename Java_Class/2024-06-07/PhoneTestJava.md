package com.keduit;

public class PhoneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Phone 타입의 객체를 생성하고 그 주소를 myPhone이라는 참조변수에 대입한다.
		Phone myPhone = new Phone();
		System.out.println(myPhone); //주소값이 나온다.
		myPhone.print(); //아직 값을 안넣었기 때문에 null이 나옴.
		myPhone.model = "갤럭시 s24";
		myPhone.value = 150;
		myPhone.print();
		
		
		Phone yourPhone = new Phone();
		System.out.println(yourPhone);
		yourPhone.print();
		yourPhone.model = "아이폰";
		yourPhone.value = 300;
		yourPhone.print();
		
		
		Phone herPhone = yourPhone;
		System.out.println(herPhone);
		herPhone.model = "갤럭시 폴드";
		herPhone.value = 350;
		herPhone.print();
		
		yourPhone.print();
	}

}
