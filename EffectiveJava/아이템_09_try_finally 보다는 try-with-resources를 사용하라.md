# 아이템 9 try_finally 보다는 try-with-resources를 사용하라.

## 배경 : 
- 자바 라이브러리에는 close 메서드를 호출해 직접 닫아줘야 하는 자원이 많음.
- Inputstream, Outputstream, java.sql.Connection 등心］ 좋은 예

## ✅ try-finally
- 전통적으로 자원이 제대로 닫힘을 보장하는 수단으로 사용됨.
- but, 자원이 둘 이상이면 try-finally 방식은 너무 지저분 함.

**❌ 예전 방식 (Java 7 이전)**

```jsx
BufferedReader br = null;
try{
	br = new BufferedReader(new FileReader("test.txt");
	String line = br.readLine();
}catch(IOException e) {
	e.printStackTrace();
} finally {
	if(br != null){
		try{
			br.close(); //자원 해제
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
```

## **✅ try-with-resources란?**

> AutoCloseable 또는 **Closeable 인터페이스를 구현한 객체를** try 블록 안에서 선언하면, **try 블록이 끝날 때 자동으로 close() 호출해주는 문법**
> 

```jsx
static String firstLineOfFile(String path) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(path));
    try {
        return br.readLine(); // (1) 예외 발생 지점
    } finally {
        br.close();           // (2) 예외 발생 지점
    }
}
```

이 코드에는 **예외가 두 번 발생할 가능성**이 있음:

1️⃣ **첫 번째 예외:**

readLine() 실행 중 디스크 I/O 오류 발생

→ IOException 던짐.

2️⃣ **두 번째 예외:**

finally 블록에서 br.close() 호출 중 또 다른 IOException 발생

(예: 같은 디스크 문제, 파일 핸들이 이미 손상된 상태 등)

## **⚠️ 자바의 try-finally 구조 동작원리**

- finally 블록은 **try 블록에서 예외가 발생하더라도 반드시 실행**돼요.
- 그런데 만약 **finally 블록 내에서도 또 예외가 발생하면**,
    
    **새로 던져진 예외가 기존 예외를 덮어씌워버립니다.**
    

즉, 첫 번째 예외는 **“사라짐”** 👇

### 자바 7이 투척한 try-with-resources|JLS, 14.20.3]

- AutoCloseabie 인터페이스를 구현해야 함
- AutoCloseabie 인터페이스 내부에는 단순히 void를 반환하는 close 메서드 하나만 정의되어 있음.
- 자바 라이브러리와 서드파티 라이브러리들의 수많은 클래스와
인터페이스가 이미 AutoCloseable을 구현하거나 확장함

⇒ 닫아야 하는 자원을 뜻하는 클래스를 작성한다면 AutoCloseable을 반드시 구현하라.

try-with-resources 장점

- 짧고 읽기 수월함
- 문제 진단하기 좋음

### try-with-resources에서도 catch 절을 쓸 수 있다.

- catch 절 덕분에 try 문을 더 중첩하지 않고도 다수의 예외를 처리할 수 있다.

결론 :  꼭 회수해야 하는 자원을 다룰 때는 try-finally 말고, trywith-resources를 사용하자.
