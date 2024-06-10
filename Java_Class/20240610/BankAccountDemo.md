
```
public class BankAccountDemo {

	public static void main(String[] args) {
		
		BankAccount kim = new BankAccount();
		BankAccount lee = new BankAccount();
		
		//입금
		kim.deposit(5000);
		lee.deposit(3000);
		//출금
		kim.withDraw(2000);
		lee.withDraw(2000);
		//잔액확인
		kim.checkMyBalance();
		lee.checkMyBalance();

	}

}
```
