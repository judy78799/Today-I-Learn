package D20240607;

public class Switch5Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(howMany(1));
		System.out.println(howMany(2));
		System.out.println(howMany(3));
		howMany(1);
	}
	
	static String howMany(int n) {
		return switch(n) {
		case 1 -> "1개";
		case 2 -> "2개";
		default -> "몇개";
	};

}
	
}
