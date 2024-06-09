package Programming_Quest;

import java.util.Scanner;

public class Chap03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//01. 키보드를 입력한 정수가 19 이상이면 성년 아니면 미성년을 출력하는 프로그램을 if~else문을 사용해 작성하라.
		
//		Scanner in = new Scanner(System.in);
//		
//		int n = in.nextInt();
//		
//		
//		if(n >= 19) {
//			System.out.println("성년");
//		}else {
//			System.out.println("미성년");
//		}
		
		
		
		//02. 키보드로 등수를 입력받아 1등 아주잘했, 2-3등 잘했, 4-6등 보통입니다. 그 외 노력해야겠습니다. switch문 사용.
//		Scanner in = new Scanner(System.in);
//		int grade = in.nextInt();
//		
//		switch (grade) {
//		case 1 : System.out.println("아주 잘했습니다."); break;
//		case 2 : System.out.println("잘했습니다."); break;
//		case 3 : System.out.println("잘했습니다."); break;
//		case 4 : System.out.println("보통입니다."); break;
//		case 5 : System.out.println("보통입니다."); break; 
//		case 6 : System.out.println("보통입니다."); break;
//		default :  System.out.println("노력해야겠습니다.");
//		}
//		
		
		//03. 키보드로 입력한 양의 정수 중에서 짝수만 덧셈해서 출력하는 코드를 do~while문을 사용해 작성하라.
		//단 입력된 정수가 양수가 아니라면 입력을 종료한다.
//		Scanner in = new Scanner(System.in);
//		int num = in.nextInt();
//		int sum = 0;
//		
//		do {
//			
//			
//		if(num %2 == 0) {
//			sum += num;
//		}else {
//			continue;
//		}
//		
////		if(num<0) {
////			break;
////		}
//			
//		}while(num>0);
//		
//		
//		
		
//		//06번 문제 풀이
//		
//		
//	        Scanner input = new Scanner(System.in);
//	        
//	        System.out.print("철수 : ");
//	        String chelsoo = input.nextLine();
//	        
//	        System.out.print("영희 : ");
//	        String younghee = input.nextLine();
//
//	        
//	        
//	        //철수와 영희가 무승부인 경우
//	        if(chelsoo.equals(younghee)){
//	            System.out.println("무승부");
//	            //철수가 이기는 경우의 수
//	        } else if ((chelsoo.equals("r") && younghee.equals("s")) ||
//	                (chelsoo.equals("s") && younghee.equals("p")) ||
//	                (chelsoo.equals("p") && younghee.equals("r"))){
//	            System.out.println("철수, 승");
//	          //반대 : 영희가 이기는 경우
//	        } else {
//	            System.out.println("영희, 승");
//	        }
//	        input.close();
//	    }


		
		//07번 문제 풀이
		   
//		        String c = input("철수");
//		        String y = input("영희");
//		        whosWin(c,y);
//		    }
//		    
//		    static String whosWin(String c,String y) {
//		    	
//		        if(c.equals(y)){
//		            System.out.println("무승부");
//		            return "무승부";
//		            
//		        } else if ((c.equals("r") && y.equals("s")) ||
//		                (c.equals("s") && y.equals("p")) ||
//		                (c.equals("p") && y.equals("r"))){
//		            System.out.println("철수, 승");
//		            return "철수, 승";
//		        } else {
//		            System.out.println("영희, 승");
//		            return "영희, 승";
//		        }
//		    }
//		    
//		    
//		    //input 메서드 선언
//		    //String name을 매개변수로 받음.
//		    
//		    static String input(String name) {
//		    	
//		    	//name이 철수와 같다면~?
//		        if (name.equals("철수")) {
//		        	//리턴 값 : 철수가 내는 것
//		            return "r";
//		          //name이 영희라면~?
//		        } else {
//		        	//리턴 값 : 영희가 내는 것
//		            return "p";
//		        }
		
		
		//08번
//	        System.out.println(factorial(5));
//	    }
//	    
//	    static int factorial(int n) {
//	        int sum = 1;
//	        
//	        for(int i =5; i>=1; i--) {
//	        	
//	        switch (n) {
//	        case 5 -> sum *= n;
//	        case 4 -> sum *= n;
//	        case 3 -> sum *= n;
//	        case 2 -> sum *= n;
//	        case 1 -> sum *= n;
//	        default -> sum *= n;
//	        }
//	        n--;
//	    }
//	        return sum;
//	    }
	
	    
	    
	    
	    //+9번문제
	    // foo("안녕",1);
//        foo("안녕하세요",1,2);
//        foo("잘 있어");
//    }
//    
//    static void foo(String message, int num) {
//        System.out.println(message + " " + num);
//    }
//    
//    static void foo(String message, int num, int num2) {
//        System.out.println(message + " " + num + " " + num2);
//    }
//    
//    static void foo(String message) {
//        System.out.println(message);
//    }
		
		
		
		
    
    
    //마지막
    
    System.out.println("양의 정수를 입력하세요 : ");
    @SuppressWarnings("resource")
    int num = new Scanner(System.in).nextInt();
    if(isPrime(num))
        System.out.println(num + "는 소수입니다.");
    else
        System.out.println(num + "는 소수가 아닙니다.");
    
    
}

static boolean isPrime(int num) {
    if(num < 1) {
        return false; 
    }
    for(int i = 2;i <= Math.sqrt(num);i++) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	


}
