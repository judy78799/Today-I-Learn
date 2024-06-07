package D20240607;

public class Switch2Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		whoIsIt("사자");
		whoIsIt("금붕어");
		whoIsIt("비둘기");
		whoIsIt("티라노");
	
		
	}
	
	//main 밖에서 선언한 static 메서드
	static void whoIsIt(String bio) {
		String kind = ".....";
		//string에서 매개 변수로 받은 값을 사용하겠다.
		
		switch (bio) {
		case "호랑이":
		
		case "사자":
			kind = "포유류";
			break;
			
		case "독수리":
		case "비둘기":
			kind = "조류";
			break;
		case "연어":
		case "금붕어":
			kind = "어류";
			break;
			
		default: System.out.println("어이큐! ");
				kind = "...";
		}
		
		System.out.println(bio + "는 " + kind + "이다");
	}

}
