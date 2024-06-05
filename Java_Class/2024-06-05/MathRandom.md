package D20240605;

public class MathRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = (int)(Math.random()*6) + 1;
		
//		if(num == 6) {
//			System.out.println("6번이 나왔습니다.");
//		}else if(num == 5) {
//			System.out.println("5번이 나왔습니다.");
//		}else if(num == 4) {
//			System.out.println("4번이 나왔습니다.");
//		}else if(num == 3) {
//			System.out.println("3번이 나왔습니다.");
//		}else if(num == 2) {
//			System.out.println("2번이 나왔습니다.");
//		}else if(num == 1) {
//			System.out.println("1번이 나왔습니다.");
//		}
		
			System.out.println("**주사위 굴리기**");
			System.out.printf("%d번이 나왔습니다.", num);
	}

}
