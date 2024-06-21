package com.keduit;

//인터페이스 Printable을 구현한 클래스
public class _06_Printer implements _05_Printable {

	//implements 이걸로 받아왔기 때문에 반드시 재정의 해줘야 함.
	@Override
	public void print(String s) {
		System.out.println(s);
	}

}
