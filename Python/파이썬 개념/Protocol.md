## 🔹 Protocol의 핵심
- “이 타입은 이런 메서드/속성을 제공해야 한다”라는 인터페이스 정의.
- 명시적인 상속이 없어도, 해당 메서드/속성을 만족하면 그 타입으로 봄. (→ 구조적 서브타이핑 / duck typing)

- 즉, 런타임 duck typing을 정적 타입 체커 수준에서 보장할 수 있게 해주는 도구.

## 🔹 Protocol 상속의 의미
- Protocol은 typing 모듈에서 제공하는 특수한 BASE 클래스.
- Protocol을 상속한 클래스는 **정적 타입 검사기(mypy, pyright 등)**에서 인터페이스(duck typing 규칙)로 취급.
- 즉, 이 프로토콜울 상속한 클래스 내부에 정의된 메서드/속성을 가진 객체라면 그 객체가 Savable을 구현했다고 본다.
- 해당 메서드의 반환 타입이나 매개변수가 **같아야** 함 == 메서드 시그니처까지 일치해야 함.

### 메서드 시그니처 범위
1.	메서드 이름
2.	매개변수(parameter) 목록과 타입
3.	반환 타입(return type)

```
from typing import Protocol

class Savable(Protocol):  # 이 클래스는 Protocol을 기반으로 정의된 인터페이스(프로토콜)
    def save(self) -> None:
        """객체를 저장하는 메서드 (구현 필요)"""
        ...

class User:
    def __init__(self, name: str):
        self.name = name
    
    def save(self) -> None:
        print(f"User {self.name} 저장됨")

def persist_1(obj: Savable):  # Savable 구현
    obj.save()

user = User("Alice")
persist(user)   # ✅ OK: User는 Savable을 명시적으로 상속하지 않았지만 save()가 있으므로 통과

class Product:
    def __init__(self, name: str):
        self.name = name
    
    def save(self) -> None:  # Savable 구현
        print(f"상품 {self.name} 저장됨")

def persist_2(obj: Savable) -> None:  # Savable 구현
    """어떤 객체든 저장 가능한 타입(Savable)만 받음"""
    obj.save()
```
•	User는 Savable을 상속하지 않았음.
•	하지만 save() 메서드를 가지고 있기 때문에, 타입 검사기는 User를 Savable로 인정함.
•	이게 structural subtyping (구조적 서브타이핑) 개념.
  
사용 예시
```
u = User("Judy")
p = Product("컴퓨터")

persist(u)  # ✅ User는 Savable 명시적 상속 없음, 하지만 save() 구현 → 통과
persist(p)  # ✅ Product도 동일
```
save()가 없는 경우
```
class Order:
    def __init__(self, order_id: int):
        self.order_id = order_id

o = Order(123)
persist(o)  # ❌ 타입 체커에서 오류: "Order" has no attribute "save"
```
