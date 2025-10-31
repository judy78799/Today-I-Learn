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


# **🟦 1. 서론 (Introduction)**

**📘 발표 목적**

- 이번 발표에서는 **이펙티브 자바 아이템 10**에서 다루는 equals() 메서드 재정의 원칙을 이해하고,
    
    이를 잘못 구현했을 때 발생하는 문제와 올바른 구현 방법을 명확히 정리한다.
    

**📌 배경 / 문제 인식**

- 자바의 모든 클래스는 기본적으로 Object.equals()를 상속받지만,
    
    **논리적 동치성(logical equality)** 을 비교하려면 재정의가 필요하다.
    
- 하지만 equals를 잘못 재정의하면 컬렉션(HashSet, HashMap 등)에서 예기치 않은 버그가 발생한다.

**🎯 목표 / 기대 효과**

- equals()의 **일반 규약(5가지)** 을 완벽히 이해한다.
- 재정의 시 **지켜야 할 원칙과 피해야 할 함정**을 습득한다.
- 객체 동치성 설계에 대한 **논리적 사고력과 코드 품질 향상**을 목표로 한다.

---

# **🟨 2. 본론 (Main Content)**

## **1️⃣ 핵심 개념 정리 (장점 & 단점)**

| **구분** | **설명** |
| --- | --- |
| **동일성(identity)** | 두 객체의 참조가 같음 (==) |
| **동치성(equality)** | 두 객체의 “논리적 내용”이 같음 (equals()) |
| **기본 equals** | Object.equals()는 동일성 비교 (==) 수행 (객체의 주소 값) |
| **재정의 필요 시점** | 객체의 **논리적 동치성**을 정의해야 할 때 (예: 값 객체) |
| **재정의 불필요 시점** | enum, 싱글턴, ==로 충분한 객체 (예: Thread, Socket 등) |

📍 **장점**

- 객체의 의미적 비교 가능 → 비즈니스 로직 명확화
- 컬렉션 내 검색·비교 기능 정상 작동 (HashMap key 등)

⚠️ **단점 / 주의점**

- equals와 hashCode 불일치 시, 해시 기반 컬렉션 오작동
- 상속 구조에서는 대칭성·추이성 위반 가능성 존재

---

## **2️⃣ equals의 일반 규약 (5가지 원칙)**

| **규약** | **설명** | **예시** |
| --- | --- | --- |
| **① 반사성 (Reflexive)** | x.equals(x)는 항상 true | 자기 자신은 자신과 같아야 함 |
| **② 대칭성 (Symmetric)** | x.equals(y)가 true면 y.equals(x)도 true | ColorPoint vs Point 비교 시 주의 |
| **③ 추이성 (Transitive)** | x.equals(y), y.equals(z) → x.equals(z) | 상속 구조에서 규약 위반 위험 |
| **④ 일관성 (Consistent)** | 값이 변하지 않는 한 결과는 항상 같아야 함 | 외부 상태에 의존 X |
| **⑤ null-비교 시 false** | x.equals(null)은 항상 false | NullPointerException 발생 X |

## **3️⃣ 구현 시 권장 순서**

1️⃣ **== 비교 (성능 최적화)**

```jsx
if (this == obj) return true;
```

2️⃣ **instanceof 검사 (타입 체크)**

```jsx
if (!(obj instanceof MyClass)) return false;
```

3️⃣ **형변환 후, 주요 필드 비교**

```jsx
MyClass other = (MyClass) obj;
return field1.equals(other.field1)
    && field2 == other.field2;
```

4️⃣ **null-safe equals 사용 권장**

```jsx
Objects.equals(field1, other.field1);
```

## **4️⃣ equals 재정의 시 흔한 실수 & 해결방안**

| **실수 유형** | **문제점** | **해결 방법** |
| --- | --- | --- |
| **상속 구조에서 equals 재정의** | 대칭성·추이성 깨짐 (ColorPoint 문제) | 상속보다 컴포지션 사용 |
| **hashCode 미재정의** | HashSet, HashMap 에서 동치 객체 탐색 실패 | equals 재정의 시 반드시 hashCode도 재정의 |
| **Float/Double 비교** | 부동소수점 정밀도 문제 | Float.compare() / Double.compare() 사용 |
| **성능을 위해 필드 일부만 비교** | 논리적 불일치 | 의미적으로 동일해야 하는 모든 필드 비교 |
| **외부 자원/가변 필드 비교** | 일관성 위반 가능 | 불변(immutable) 필드만 비교 |

## **5️⃣ 실제 코드 예시**

### **✅ 올바른 equals 구현 예**

```jsx
public final class PhoneNumber {
    private final int areaCode, prefix, lineNum;

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNum == lineNum &&
               pn.prefix == prefix &&
               pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }
}
```

### **❌ 잘못된 예시 (ColorPoint 문제)**

```jsx
public class Point {
    private final int x, y;
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
}

public class ColorPoint extends Point {
    private final Color color;
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint)) return false;
        return super.equals(o) && ((ColorPoint) o).color == color;
    }
}
```

→ new ColorPoint(1,2,RED).equals(new Point(1,2))는 true,

하지만 반대는 false → **대칭성 위반!**

✅ **해결**: 상속 대신 컴포지션 사용

```jsx
class ColorPoint {
    private final Point point;
    private final String color;

    public ColorPoint(int x, int y, String color) {
        this.point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorPoint)) return false;
        ColorPoint cp = (ColorPoint) obj;
        return point.equals(cp.point) && color.equals(cp.color);
    }
}
```

# **🟩 3. 요약 (Summary / Conclusion)**

**핵심 포인트 요약**

- equals()는 **반사성·대칭성·추이성·일관성·null 불일치**의 규약을 반드시 지켜야 한다.
- **논리적 동치성**을 명확히 정의해야 컬렉션과 프레임워크 동작이 예측 가능하다.
- equals를 재정의하면 **hashCode도 반드시 함께 재정의**해야 한다.
- **상속보다 컴포지션을 사용**해 규약 위반을 피하라.

---

**느낀 점 / 인사이트**

- equals는 단순 비교 함수가 아니라, **객체의 논리적 동일성을 정의하는 계약(Contract)** 이다.
- 이 계약을 지키는 것이 코드 품질, 테스트 안정성, 그리고 협업 신뢰성의 핵심임을 깨달았다.

---

**다음 단계 제안**

- 다음 발표에서는 **아이템 11: equals를 재정의하려거든 hashCode도 함께 재정의하라**를 다뤄,
    
    해시 기반 자료구조(HashMap, HashSet)에서의 동작 원리를 함께 살펴볼 예정이다.
