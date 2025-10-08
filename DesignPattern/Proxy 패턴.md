# Proxy 패턴
# 2025-10-08 DIL

|주차|DIL 범위|날짜|개인 진도|
|------|---|---|---|
| 1주차 |part21|2024-10-08|380-392p|


Proxy == 중계 대리인 == 어떤 일을 대신 시키는 것

## Proxy 핵심
“프록시 패턴은 클라이언트가 인터페이스(Subject 타입)를 통해 Proxy에 접근하고(직접 접근 X),
Proxy는 내부에서 RealSubject를 구성(Composition)하여 접근을 제어하고, 위임(delegate)하는 구조이다.”

---

```
Client
   ↓
Subject (Interface)
   ↑          ↑
Proxy ------> RealSubject
```

<img width="2484" height="1012" alt="image" src="https://github.com/user-attachments/assets/9e4036fb-f5aa-4452-aed7-5fc70650153e" />

- Proxy는 Subject를 구현(implements) 하거나 상속(extends).
- 따라서 Proxy는 Subject 타입으로 "다형적"으로 취급될 수 있음. (클라이언트가 Subject로 Proxy에 접근할 수 있는 이유)
- 즉, 클라이언트는 Subject 타입만 알고 있어도, 실제로는 Proxy 객체를 주입받아 사용할 수 있음.

---

```
from abc import ABC, abstractmethod

# --- Subject (인터페이스 역할)
class Subject(ABC):
    @abstractmethod
    def request(self) -> None:
        pass


# --- RealSubject (실제 대상)
class RealSubject(Subject):
    def request(self) -> None:
        print("🔹 RealSubject: 실제 요청을 처리 중...")


# --- Proxy (대리자)
class Proxy(Subject):
    def __init__(self, real_subject: RealSubject):
        self._real_subject = real_subject  # Composition (구성)

    def request(self) -> None:
        # 1️⃣ 접근 제어 로직 (예: 인증, 캐싱, 로깅 등)
        if self._check_access():
            print("✅ Proxy: 접근 허용")
            self._real_subject.request()  # 실제 객체에게 위임(delegate)
            self._log_access()
        else:
            print("❌ Proxy: 접근 거부")

    def _check_access(self) -> bool:
        print("🔍 Proxy: 접근 권한 확인 중...")
        return True

    def _log_access(self) -> None:
        print("🪵 Proxy: 요청 로그 기록 완료")


# --- Client
def client_code(subject: Subject):
    """클라이언트는 Subject 인터페이스만 알고 있다."""
    subject.request()


# --- 실행
real = RealSubject()
proxy = Proxy(real)
print("➡ 클라이언트가

Proxy를 통해 접근")
client_code(proxy)
```

### 🔷 핵심 동작 흐름
1. 클라이언트는 client_code(subject: Subject) 형태로, 오직 Subject 타입만 알고 있음. (클라이언트는 RealSubject가 있는지조차 몰라도 됨.)
2. 실제로 넘겨주는 객체는 Proxy(RealSubject()). (Proxy 객체는 내부에 RealSubject를 구성(Composition) 형태로 포함.)
→ 즉, Proxy가 “RealSubject로의 진입문” 역할을 함.
3. Proxy는 Subject를 상속했기 때문에, client_code()는 이를 Subject처럼 호출할 수 있습니다.
4. 내부적으로는 Proxy가 RealSubject를 포함(Composition)하고 있으므로, 실제 로직은 RealSubject가 처리.

### ⚙️ 클라이언트의 접근 방식

- 클라이언트는 인터페이스 타입(Subject) 을 통해 Proxy 객체에 접근하고,
- Proxy는 Composition을 통해 RealSubject를 제어한다.

---

## 🔶 다형성
상위 타입(Subject) 참조가 하위 타입(Proxy, RealSubject) 객체를 가리킬 수 있음

- ✅ client_code(subject: Subject) 처럼 상위 타입(인터페이스)에 의존해야 <br>
하위 구현체가 바뀌어도 클라이언트는 몰라도 된다.
- ❌ client_code(proxy: Proxy)처럼 하위 클래스에 의존하면 <br>
다형성을 잃고, 의존성이 구체 구현에 묶인다.

## 🔷 다형성 vs 제네릭 상한 와일드 카드

### "상위 타입으로 하위 타입을 유연하게 받기"

|개념|의미|예시|
|---|---|---|
|다형성 (Polymorphism)|“상위 타입 참조가 하위 타입 객체를 가리킬 수 있다.”|Subject s = new Proxy();|
|제네릭 상한 와일드카드 (? extends T)|“T를 상속(또는 구현)한 하위 타입의 객체를 받을 수 있다.”|List<? extends Subject> list|


|구분|다형성|제네릭 와일드카드|
|---|---|---|
|동작 시점|런타임|컴파일타임|
|적용 대상|객체 타입|제네릭 타입 매개변수|
|핵심 키워드|extends, implements|? extends T / ? super T|


