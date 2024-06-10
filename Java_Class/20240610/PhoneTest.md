
//클래스 내부에서 변수에 할당 외부에서 변수에 할당
//오버로딩으로 print() 와 print(a,b); 둘 다 사용가능.


package com.keduit;

public class PhoneTest {

    public static void main(String[] args) {
        // Phone타입의 객체를 생성하고 그 주소를 myPhone이라는 참조변수에 대입한다.
        Phone myPhone = new Phone();
        System.out.println(myPhone);
        myPhone.print();
        myPhone.model = "갤럭시 s24";
        myPhone.value = 150;
        myPhone.print();
        
        Phone yourPhone = new Phone();
        System.out.println(yourPhone);
        yourPhone.model = "아이폰";
        yourPhone.value = 150;
        yourPhone.print();
        
        yourPhone.print("아이폰", 250);
        
        yourPhone.model = "갤럭시 s24";
        yourPhone.value = 150;

        
        if(myPhone == yourPhone) {
            System.out.println("myPhone과 yourPhone은 같다." + (myPhone == yourPhone));
        } else {
            System.out.println("myPhone과 yourPhone은 다르다." + (myPhone == yourPhone));
            
        }
        
        Phone herPhone = yourPhone;
        System.out.println(herPhone);
        herPhone.model = "갤럭시 폴드";
        herPhone.value = 200;
        herPhone.print();
        
        yourPhone.print();
        
    }

}
