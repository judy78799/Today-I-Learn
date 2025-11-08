> 아이템 14. Comparable을 구현할 지 고려하라.
> 

# **🟦 1. 서론 (Introduction)**

### **발표 목적**

- Comparable 인터페이스의 역할과 compareTo() 메서드의 규약을 이해하고,
    
    이를 올바르게 구현하는 방법을 학습한다.
    

### **배경 / 문제 인식**

- 객체의 동치성(equals)만으로는 “순서”를 정의할 수 없다.
- 정렬, 탐색, 정렬된 컬렉션(TreeSet, TreeMap)을 활용하려면 **객체의 자연 순서(Natural Order)** 가 필요하다.
- 잘못된 compareTo() 구현은 **정렬 불가능**, **규약 위반**, **데이터 불일치** 문제를 초래한다.

### **목표 / 기대 효과**

- Comparable 인터페이스의 규약을 이해하고, equals와 일관성 있는 구현 방식을 익힌다.
- 자바 8 이후의 **비교자 생성 메서드(Comparator.comparingInt 등)** 를 활용해 간결하고 안전한 compareTo()를 작성할 수 있다.

---

# **🟨 2. 본론 (Main Content)**

## **1️⃣ 핵심 개념 정리**

|  | **내용** |
| --- | --- |
| **Comparable** | 객체의 “자연 순서”를 정의하는 제네릭 인터페이스 (compareTo 메서드 1개) |
| **compareTo() 규약** | ① 대칭성, ② 추이성, ③ 일관성 유지해야 함 |
| **equals와 차이점** | equals는 **동치성**, compareTo는 **순서성** 비교 |
| **일관성 원칙** | (x.compareTo(y) == 0) ↔ (x.equals(y))가 일치하면 좋음 |
| **장점** | 정렬(Arrays.sort), 탐색(Collections.binarySearch), 정렬된 컬렉션(TreeSet, TreeMap)과 호환 가능 |

## **2️⃣ 주요 규약 요약**

1️⃣ **대칭성**

- sgn(x.compareTo(y)) == -sgn(y.compareTo(x))

- → 순서를 바꿔도 부호만 반대여야 함.

2️⃣ **추이성**

- x > y, y > z ⇒ x > z

- → 순서 관계가 일관돼야 함.

3️⃣ **일관성**

- x.compareTo(y) == 0이면

- 모든 z에 대해 x와 y는 동일한 순서 관계를 가져야 함.

4️⃣ **equals와의 일관성(권장)**

- compareTo 결과가 0이면 equals도 true 여야 함.

- (일관되지 않으면 TreeSet, TreeMap 등에서 예상치 못한 버그 발생 가능)

---

## **3️⃣ 규약 위반 사례**

### **💥 Point → ColorPoint 확장 문제**

```java
class Point implements Comparable<Point> {
    int x, y;
    public int compareTo(Point p) { ... }
}
class ColorPoint extends Point {
    Color color; // 새로운 값 컴포넌트 추가
}
```

- compareTo 규약을 완벽히 지킬 수 없다.
    
    (비교 시 색상까지 고려하면 Point와의 대칭성 깨짐, 고려하지 않으면 ColorPoint 간 추이성 깨짐)
    

📌 해결책:

Comparable을 상속한 구체 클래스에서 필드가 추가되면

> “순서가 equals와 일관되지 않는다”는 점을 명시적으로 문서화해야 함.
> 

---

## **4️⃣ equals vs compareTo 정리**

| **구분** | **equals** | **compareTo** |
| --- | --- | --- |
| **비교 대상** | 모든 객체 | 동일 타입 객체만 |
| **비교 기준** | 논리적 동등성 | 순서(크다/작다/같다) |
| **타입 다름 시** | false 반환 | ClassCastException |
| **활용 예시** | HashSet, HashMap | TreeSet, TreeMap |

📌 예시 — BigDecimal의 불일치(compareTo 와 equals가 일관되지 않는 클래스.)

```java
new BigDecimal("1.0").equals(new BigDecimal("1.00")) // false
new BigDecimal("1.0").compareTo(new BigDecimal("1.00")) // 0
```

→ HashSet은 두 개의 원소, TreeSet은 하나의 원소로 인식됨.

## **5️⃣ compareTo 작성 요령**

- 각 필드의 “순서”를 비교해야 하며, < / > 연산자 대신 **정적 compare() 메서드** 사용
- 여러 필드가 있을 경우 **핵심 필드 → 보조 필드 순**으로 비교
- 자바 8 이후에는 Comparator의 **비교자 생성 메서드 체이닝** 사용 권장

**📘 예시 — 자바 8 이후 버전 → 메서드 연쇄 (체이닝) 방식**

```java
private static final Comparator<PhoneNumber> COMPARATOR =
    comparingInt((PhoneNumber pn) -> pn.areaCode).   //PhoneNumber -> 타입 추론을 돕기 위해 명시적으로 작성한 부분
        .thenComparingInt(pn -> pn.prefix)
        .thenComparingInt(pn -> pn.lineNum);

public int compareTo(PhoneNumber pn) {
    return COMPARATOR.compare(this, pn);
}
```

- comparingInt 정적 메서드
    - 객체에서 int형 키를 추출해 순서를 정의
    - 람다를 인수로 받는다. (PhoneNumber pn) -> pn.areaCode)
- 람다에서 타입 명시((PhoneNumber pn))가 필요한 이유:
    
    - **자바의 타입 추론 한계 + 제네릭 타입 소거(Type Erasure)**
    
- thenComparingInt 체이닝으로 다단계 비교 가능

### 🌀 자바의 타입 추론 한계

comparingInt의 제네릭 타입 매개변수를 **람다에서 생략했을 경우 컴파일러가 자동으로 추론하지 못한다.**

- 입력 인수의 타입(PhoneNumber pn)을 명시한 이유
    
    ### **💡 1️⃣ 비교자 생성 메서드 comparingInt 구조 이해**
    
    Comparator.comparingInt의 정의
    
    ```jsx
    public static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor)
    ```
    
    - 제네릭 타입 <T> : 비교 대상 객체의 타입
    - keyExtractor : T → int값을 추출하는 함수 (PhoneNumber → areaCode)
    
    ### **💡 2️⃣ 코드에서 타입 추론이 필요한 부분**
    
    ```java
    priavte static final Comparator<PhoneNumber> COMPARATOR =
    		comparingInt((PhoneNumber pn) -> pn.areaCode)   //comparingInt에 "PhoneNumber" 타입 명시를 해줌.
    			.thenComparingInt(pn -> pn.prefix)
    			.thenComparingInt(pn -> pn.lineNum);
    ```
    
    ### ❓왜 타입 명시를 해줬는가?
    
    - 자바 컴파일러가 (PhoneNumber pn)의 타입을 **자동으로 추론해야 하는데**, 그걸 제대로 못하는 상황이 발생함.
    - comparingInt는 **정적 메서드(static method)** 이고, 그 제네릭 타입 <T>를 **파라미터로 전달받은 람다식**을 보고 유추해야 하는데, 그 람다의 입력 값이 명시되어 있지 않으면 **T가 뭔지 모름**.
    
    ```java
    //컴파일러는 pn의 타입을 추론할 단서가 없음.
    comparingInt(pn -> pn.areaCode) //pn이 어떤 클래스인지 comparingint 입장에서는 모름.
    ```
    
    ### **💡 5️⃣ thenComparingInt(pn -> pn.prefix)는 괜찮을까?**
    
    - 첫 번째로 타입이 고정된 이후에는 체이닝된 나머지 비교자들도 타입을 안전하게 추론할 수 있게 됨.
    
    ---
    
    🤔 Question 대입문 **왼쪽 타입으로부터 역추론 못함의 이유**
    
    > COMPARATOR의 선언부에 이미 Comparator<PhoneNumber>라고 명시돼 있으니까
    컴파일러가 “아, 이건 PhoneNumber끼리 비교하겠구나” 하고 **추론할 수도 있지 않을까요?**
    > 
    
    → A : 자바 11 이상 컴파일러에서는 잘 컴파일 됨. 
    하지만 예전 자바 버전인 자바 8 초기의 경우 타입 추론이 강력하지 않음.
    
    ### ✚ 참고) 자바의 타입 추론 규칙 (두 가지 원칙)
    
    ```java
    // 자바의 타입 추론 두 가지 규칙
    1. 람다 내부의 타입은 람다가 전달되는 “메서드 인자”로부터 추론된다.
        즉, 함수형 인터페이스(여기선 ToIntFunction<T>)의 타입 매개변수에 따라 매개변수 타입이 결정됨.
        
    2. 대입문 왼쪽(Comparator<PhoneNumber> COMPARATOR)의 타입은 전체 식의 **결과**를 검증할 때만 사용됨.
        즉, “결과가 이 타입과 호환되는가?”는 검사하지만, “람다 내부의 매개변수 타입을 역으로 유추하는 데”는 사용하지 않음.
    ```
    
    ✅ 즉, **람다의 타입 추론은 항상 “메서드 호출의 문맥”에서 이뤄지지, 대입문의 왼쪽 타입에서(선언부) 이뤄지지 않는다.**
    
    ### ❓ 실제로 타입명시를 생략했을 경우
    
    ```java
    private static final Comparator<PhoneNumber> COMPARATOR =
        comparingInt(pn -> pn.areaCode)   // pn 타입 생략
            .thenComparingInt(pn -> pn.prefix)
            .thenComparingInt(pn -> pn.lineNum);
    ```
    
    ✅ 대부분의 현대 컴파일러 (Java 11 이상)에서는 잘 컴파일 됨.
    
    thenComparingInt() 체이닝 덕분에 문맥상 타입을 점진적으로 추론할 수 있기 때문.
    
    ### 📌 **책에서 말하는 “타입 추론이 강력하지 않다”는 문맥이란,**
    
    - 예전 자바 버전 (Java 8 초기)
    - 또는 **컴파일러가 문맥만으로 T를 정확히 유추할 수 없는 복잡한 제네릭 체이닝**일 경우
        
        를 포함해 말하는 것임.
        

## 🔶 자바 7이후 변화

⏪ 이전 이펙티브 자바 2판의 내용

```jsx
정수 기본 타입 필드를 비교할 때 관계 연산자인 <와 >를, 실수 기본 타입 필드를 비교할 때는 정적 메서드인 [Double.compare](http://Double.compare)와 Float.compare를 사용하라고 권함.
```

✅ 자바 7 이후 변경 내용 : 박싱된 기본 타입 클래스들에 새로 추가된 정적 메서드 compare(). 

클래스에 핵심 필드가 여러 개인 경우 → “가장 핵심적인 필드” 중 순서가 있는 것. 

- 순서가 결정되는 경우 (비교 결과가 0이 아닌 경우)를 찾아 먼저 비교 해나간다.
- 핵심이 되는 필드가 똑같다면, 똑같지 않은 필드를 찾을 때 까지 그 다음으로 중요한 필드를 비교해나간다.

기본 타입 필드가 여럿일 때의 비교자 (아이템 10의 PhoneNumber 클래스용 compareTo 메서드 )

```jsx
public int compareTo(PhoneNumber pn){
	int result = Short.compare(areaCode, pn.areaCode);   //가장 중요한 필드.
	int(result == 0){
		result = Short.compare(prefix, pn.prefix);     //두 번째로 중요한 필드.
		if (result == 0)
			result = Short.compare(lineNum, pn.lineNum);     //세 번째로 중요한 필드.
	}
	return result;
}
```

## Comparator의 수많은 보조 생성 메서드들

- long과 double용 : comparinglnt와 thenComparinglnt의 변형 메서드
- short : int용 버전을 사용
- float : double용 사용

## 🚨 추이성을 위배하는 경우

해시코드 값의 차를 기준으로 하는 비교자

```java
static Comparator<Object> hashCodeOrder = new Comparator<>(){
	public int compare(Object o1, Object o2){
		return o1.hashCode() - o2.hashCode();
	}
};
```

사용하지 말자!

- 정수 오버플로를 일으키거나 IEEE 754 부동소수점 계산 방식에 따른 오류를 낼 수 있다.

### ✅ 대안방식 (두 가지)

1.정적 compare메서드를 활용한 비교자

```java
static Comparator<Object> hashCodeOrder = new Comparator<>() {
	public int compare(Object o1, Objet o2){
		return Integer.compare(o1.hashCode(), o2.hashCode());
	}
};
```

2.비교자 생성 메서드를 활용한 비교자

```java
static Comparator<Object> hashCodeOrder = 
			Comparator.comparingInt(o -> o.hashCode());
```

---

## **6️⃣ 성능 & 주의점**

- 자바 8 이후의 메서드 연쇄 방식은 가독성이 높지만, 약 10%의 성능 저하 발생 가능
- 정적 임포트를 사용하면 코드 간결화 가능
- 정수 오버플로우 방지를 위해 o1.hashCode() - o2.hashCode() 대신 Integer.compare() 사용

---

# **🟩 3. 요약 (Summary / Conclusion)**

### **핵심 포인트**

- Comparable은 객체의 **자연 순서**를 정의하기 위한 인터페이스
- compareTo는 **반사성·대칭성·추이성**을 지켜야 하며, 가능하면 equals와 일관되게 작성
- <, > 연산 대신 Integer.compare, Comparator.comparingInt 등 안전한 메서드 사용
- 정렬 컬렉션(TreeSet, TreeMap)은 equals가 아닌 compareTo로 동치성 판단함

### **느낀 점 / 인사이트**

- “객체의 정렬 가능성”은 단순한 편의 기능이 아니라,
    
    컬렉션의 내부 동작과 일관성을 보장하는 핵심 규약임을 알게 되었다.
    
- Comparable을 올바르게 구현하지 않으면 컬렉션, 정렬, 탐색 알고리즘 전반이 오동작할 수 있다.

### **다음 단계 제안**

- Comparator 인터페이스의 고급 활용법 (e.g. 복합 정렬, null 우선순위, 역순 정렬)
- TreeSet, TreeMap 내부에서 compareTo가 실제로 어떻게 호출되는지 디버깅 분석
