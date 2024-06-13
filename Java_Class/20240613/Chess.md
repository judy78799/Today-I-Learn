//private 앞에 붙이면
//class - 상속 불가
//메서드 - 오버라이딩 불가
class Chess {
	
	enum ChessPlayer{
		WHITE,BLACK
	}
	
	final ChessPlayer getFirstPlayer() {
		return ChessPlayer.WHITE;
	}
	
}

class WorldChess extends Chess{
	//ChessPlayer getFirstPlayer()
}


//퍼블릭은 하나만 있어야 함
public class FinalMethodDemo {

	public static void main(String[] args) {
		WorldChess w = new WorldChess();
		System.out.println(w.getFirstPlayer());
	}

}
