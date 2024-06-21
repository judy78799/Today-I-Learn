package com.keduit;

//람다식을 매개변수로 보낼 수 있다.
public class _09_Lambda4Demo {

	public static void main(String[] args) {
		showString((s) -> {System.out.println(s);}, "람다식을 매개변수로 보낼 수 있다.");
	}
	
	public static void showString(_05_Printable p, String s) {
		p.print(s);
	}

}
