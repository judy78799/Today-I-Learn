# 아이템_10_equals는 일반 규약을 지켜 재정의하라.

> equals 메서드는 재정의하기 쉬워 보이지만 곳곳에 함정이 도사리고 있어서
자칫하면 끔찍한 결과를 초래한다.
> 

## equals 메서드를 재정의하지 않는 것이 좋을 때

- 각 인스턴스가 본질적으로 고유하다.
- 인스턴스의 ‘논리적 동치성(logical equality)’을 검사할 일이 없다.
- 상위 클래스에서 재정의한 **equals**가 하위 클래스에도 딱 들어맞는다.
- 클래스가 private이거나 package-private이고 **equals** 메서드를 호출할 일이 없다.

equals가 실수로라도 호출되는 걸 막고 싶다면?

```jsx
@Override public boolean equals (Object o) {
throw new AssertionError(); // 호출 금지!
}
```

## equals를 재정의해야 할 때

객체 식별성(object identity두 객체가 물리적으로 같은가)이 아니라 논리적 동치성을 확인해야 하는데, 상
위 클래스의 eq니als가 논리적 동치성을 비교하도록 재정의되지 않았을 때.

값 클래스

- Integer와 String처럼 값을 표현하는 클래스
- Enum

## equals 메서드를 재정의할 때는 반드시 일반 규약을 따라야 한다.

equals 메서드는 동치관계(equivalence relation)구현하며, 다음을 만족한다.

- 반사성(reflexivity)： null이 아닌 모든 참조 값 x에 대해, x.equals(x)는 true다.
- 대칭성(symmetry)： n니II이 아닌 모든 참조 값 x, y에 대해, x.equals(y)가 true면 y.equals(x) 도 true 다.
- 추이성(transitivity)： null이 아닌 모든 참조 값 x, y, z에 대해, x.equals(y)가 true이고 y.equals(z)도 true면 x.equals(z)도 true다.
- 일관성(consistency)： n니II이 아닌 모든 참조 값 x, y에 대해, x.equals(y)를 반복해서 호출하면 항상 true를 반환하거나 항상 false를 반환한다.
- **null-**아님: null이 아닌 모든 참조 값 x에 대해, x.equals(null)은 false다.

규약의 중요성

- 규약을 어기면 프로그램이 이상하게 동작하 거나 종료될 것이고,
- 원인이 되는 코드를 찾기도 굉장히 어려울 것이다.
- 세상에 홀로 존재하는 클래스는 없다. (feat. John Donne)
: 한 클래스의 인스턴스는 다른 곳으로 빈번히 전달된다. 그리고 컬렉션 클래스들을 포함해 수
많은 클래스는 전달받은 객체가 equals 규약을 지킨다고 가정하고 동작한다.

## equals 규약을 자세히 알아보자

- Object 명세에서 말하는 동치관계 : 집합을 서로 같은 원소들로 이뤄진 부분집합(동치류: (equivalence class； 동치 클래스))으로 나누는 연산
- equals 메서드가 쓸모 있으려면 모든 원소가 같은 동치류에 속한 어떤 원소와도 서로 교환할 수 있어야 한다.

### 동치관계를 만족시키기 위한 다섯 요건

- 반사성
    - 객체는 자기 자신과 같아야 한다.
    
    ```jsx
    반사성을 어긴 예 + 요건을 어긴 클래스의 인스턴스를 컬렉션에 넣은 다음 contains 메서드를 호출하는 예
    ```
    
- 대칭성
    - 두 객체는 서로에 대한 동치 여부에 똑같이 답해야 한다
    대소문자를 구별하지 않는 문자열
- 추이성
  - 첫 번째 객체와 두 번째 객체가 같고, 두 번째 객체와 세 번째 객체가
같다면, 첫 번째 객체와 세 번째 객체도 같아야 한다.
