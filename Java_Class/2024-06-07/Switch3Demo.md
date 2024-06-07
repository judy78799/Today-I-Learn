package D20240607;

public class Switch3Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = whoIsIt("호랑이");
		System.out.println(whoIsIt("참새"));
		result = whoIsIt("티라노");
		System.out.println("티라노는" + result + "입니다");

	}
	
	static String whoIsIt(String bio) {
		
		String kind = "...";
		switch (bio) {
		case "호랑이", "사자" ->  kind = "포유류"; 
		case "독수리", "참새" ->  kind = "조류"; 
		case "고등어", "연어" ->  kind = "어류";
//		default -> kind = "어이쿠";
		default -> {
			System.out.println("어이큐!");
		}
		}
		return kind;
	}

}
