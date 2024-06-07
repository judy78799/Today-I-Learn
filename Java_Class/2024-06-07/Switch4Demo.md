package D20240607;

public class Switch4Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		whoIsIt("호랑이");
		whoIsIt("티라노");
		whoIsIt("참새");
		whoIsIt("연어");
	}
	
	
	static void whoIsIt(String bio) {
		
//		String kind = switch(bio) {
//			case "호랑이","사자" -> "포유류";
//			case "독수리","참새" -> "조류"; //"" 안에 띄어쓰기가 있는 것과 없는 것은 다르다.
//			case "고등어","연어" -> "어류";
//			default -> {
//				System.out.println("어이큐!");
//				yield "..."; //yield 역할 : 값 반환(리턴) + 브레이크 역할 해줌.
//			}
//		};
//		System.out.println(bio + "는 " + kind + " 입니다");
//	}
	
	//위 문장을 yield를 사용하여 표현
	
	String kind = switch(bio) {
		case "호랑이","사자" : yield "포유류";
		case "독수리","참새" : yield "조류";
		case "고등어","연어" : yield "어류";
		default : 
			
			System.out.println("어이쿠!");
			yield "...";
			
	};
	System.out.println(bio + "는" + kind + "입니다");
	}
}
