```
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "한정교";
		String str2 = "한정교";
		
		if(str1 == str2) {
			System.out.println("str1과 str2는 참조가 같습니다.");
		}else{
			System.out.println("str1과 str2는 참조가 다릅니다.");
		}
		
		String str3 = new String("한정교");
		String str4 = new String("한전교");
		
		if(str3 == str4) {
			System.out.println("str3과 str4는 참조가 같습니다.");
		}else {
			System.out.println("str3과 str4는 참조가 다릅니다.");
		}
	}

```
