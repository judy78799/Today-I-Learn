# private 생성자나 열거 타입으로 싱글턴임을 보증하라

## Singleton
- 오직 하나의 인스턴스를 생성할 수 있는 클래스.
- 클래스를 싱글턴으로 만들면 이를 사용하는 클라이언트를 테스트하기 어려움.
- 가짜 mock 구현으로 대체할 수 없기 때문.

## Singleton 생성 방식 2가지
### 1. public static 멤버가 final 필드인 방식

### 💡 “API를 바꾸지 않고도”의 의미

API란 외부 코드가 사용하는 **공개 인터페이스(public methods)**를 말함.
여기서는 Elvis.getInstance()가 API임.

즉, 외부에서 사용하는 방식은 Elvis.getInstance()로 고정돼 있음.
그런데, 내부 구현을 아래처럼 바꿔도 외부는 전혀 영향을 받지 않음.

|구분|public static final 방식||정적 팩터리(getInstance) 방식|
|---|---|---|
|인스턴스 교체 가능성|❌ 고정된 싱글턴만 가능|✅ 내부 구현 변경 가능|
|API 유연성|낮음|높음|
|테스트 용이성|Mock 주입 어려움|Mock 반환 가능|
|외부 코드 변경 필요성|있음 (Elvis.INSTANCE)|없음 (Elvis.getInstance() 그대로 사용)|

## 요약
“정적 팩터리 방식의 싱글턴은 public API(getInstance)를 유지한 채 내부 구현(싱글턴 → 멀티 인스턴스)을 바꿀 수 있는 유연성을 제공한다.”
API는 “클래스 단위”가 아니라 “외부에서 접근 가능한 모든 공개 요소(public interface)”**를 뜻함.

## 🔹 **API (Application Programming Interface)**란?

“외부 코드(클라이언트 코드)가 접근할 수 있는 공개된 인터페이스의 집합”
즉,
	•	클래스, 인터페이스, 메서드, 생성자, 필드 중
	•	public, protected로 외부에 공개된 모든 것들이 API의 일부.

```
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();
    private Elvis() {}

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void sing() {
        System.out.println("🎤 Love me tender...");
    }
}
```

이 클래스의 API
- public static Elvis getInstance() 외부에서 인스턴스를 얻을 수 있는 방법
- public void sing() 외부에서 호출 가능한 동작
- Elvis 클래스 자체 외부에 공개된 타입 (public class)

