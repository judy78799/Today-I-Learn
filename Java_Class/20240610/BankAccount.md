```

public class BankAccount {

	
	
		int balance; //입금, 출금, 잔액확인의 변수를 모두 같은 것으로 선언
		
		int deposit(int amount) { //void로 바꾸어줘도 상관 없음.
			balance += amount;
			return balance;
		}
		
		
		int withDraw(int amount) { //void로 바꾸어줘도 상관 없음.
			balance -= amount;
			return balance;
		}
		
		//출력을 
		int checkMyBalance() { //void로 바꾸어줘도 상관 없음.
			System.out.println("잔액: " + balance);
			return balance;
		}
	}

```
