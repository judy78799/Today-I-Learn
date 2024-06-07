package D20240607;

public class Switch7Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sum(1,10);
	}
	
	public static double Sum (int i1, int i2){
		int sum = 0;
		for(int i = i1; i <= i2; i++) { //i1 <= i2 이렇게 작성해놓으면 계속 참이 된 조건문이 되어서 무한반복함.
			sum += i;
			System.out.println(i1 + "부터"+ i2 +"합은"+ sum +"이다.");
		
		}
		
		return sum;
	}
	
	
	

}
