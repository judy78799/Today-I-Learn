# 학습 개념
- Abstract Base Classes
- Type Hints 
- Async/Await 패턴


## 1️⃣ Abstract Base Classes
	•	Python에서 인터페이스/추상 클래스 역할을 하는 것
	•	클래스의 **공통 인터페이스(메서드 시그니처)**를 정의하고,
구현은 하위 클래스가 맡도록 강제하는 구조
	•	Java의 abstract class 또는 interface와 같은 개념이라고 생각하면 됨

## 다형성
- 하나의 인터페이스를 통해 서로 다른 여러 타입을 제공하는 것
- OOP 에서 말하는 다형성: 클래스에 선언된 메서드가 상속 받은 클래스에서 같은 이름으로 오버라이딩 되어 여러 형태로 동작함을 의미

```
# 추상클래스
class BasePromptBuilder(ABC):
    """기본 프롬프트 빌더"""
    def __init__(self, userMessage: str):
        self.userMessage = userMessage
        self.hints: List[Dict] = []

    def add_hint(self, description: str, content: str):
        """
        @deprecated: 이 메서드는 더 이상 사용하지 않으며, 향후 제거될 예정입니다.
        """
        self.hints.append({"description": description, "content": content})
        return self

    def _build_hint_messages(self) -> List[Dict]:
        return [{"role": "system", "content": h["content"]} for h in self.hints]

    @abstractmethod
    def build(self) -> List[Dict]:
        pass

# 구체 클래스
class FieldsPromptBuilder(BasePromptBuilder):
    """메시지에서 변수로 처리할 필드를 추출하는 프롬프트 빌더"""
    def build(self) -> List[Dict]:
        # 오늘 날짜를 YYYY-MM-DD 형식으로 가져옵니다.
        today_str = datetime.now().strftime('%Y-%m-%d')

        system_prompt = f"""당신은 텍스트에서 변수를 추출하고 정제하는 '데이터 엔지니어'입니다...
```


## 2️⃣ 타입 힌트
	•	Python은 동적 타이핑이라 타입을 강제하지 않음
	•	Type Hints는 코드에 타입을 “주석처럼” 표기해서 가독성 + 정적 분석을 돕는 것
	•	실행 시 강제되지 않지만, mypy 같은 툴로 타입 체크 가능

  •	IDE에서 자동 완성/오류 감지 지원
	•	팀원이 코드 읽을 때 의도를 더 쉽게 파악
  •	협업 시 “이 함수가 뭘 받고 뭘 리턴하는지” 명확해짐
	•	오타·잘못된 타입을 빌드 전에 잡을 수 있음 (mypy)
	•	대규모 프로젝트일수록 필수

## 3️⃣ Async/Await 패턴 (비동기/코루틴)
  •	동시에 여러 작업을 “병렬처럼” 처리하는 Python 방식
	•	Thread/Process 대신 이벤트 루프 기반으로 동작 (I/O-bound 작업에 강함)
	•	async def로 정의된 함수(코루틴)를 await으로 호출해야 함

	•	await asyncio.sleep(2)는 2초 동안 이벤트 루프에 제어권을 넘겨줌
	•	그 동안 다른 코루틴이 실행될 수 있음

  왜 쓰나?
	•	DB 쿼리, API 호출, 파일 I/O 같은 느린 작업을 동시에 처리
	•	FastAPI, aiohttp 같은 프레임워크가 이 패턴을 적극 사용
	•	동기 코드 대비 자원 효율↑ / 속도↑

### 🔹 왜 dict, str, int 같은 일반 타입에 await을 걸면 안 되나?

1) await는 “awaitable” 객체에만 가능
	•	await는 코루틴(coroutine), Task, Future 같은 비동기 객체(awaitable)만 받을 수 있음
	•	dict, str, int는 그냥 동기적인 값이라서 이벤트 루프에 넘겨줄 게 없음

```
result = await 5  # ❌ TypeError: object int can't be used in 'await' expression
```

2) 비동기 함수는 “값을 바로 리턴”할 수도 있음
	•	async def 함수가 return 하면 그 값이 코루틴이 끝날 때 반환됨
	•	이 때 그 값이 dict든 str이든 상관없음
	•	리턴 값 타입은 자유지만,
await할 때는 그 함수(코루틴) 자체를 await해야 함
dict, str, int = 그냥 메모리에 즉시 있는 값이라 “기다림”이 없음 → await 불필요

---

즉, “await는 반드시 비동기 객체(코루틴, Task, Future)에만 붙는다”
반환값이 dict든 str이든 int든 상관없음.
그 값들은 await이 아니라 변수에 그냥 받으면 됨.

### 이벤트 루프 동작원리

```
 ┌─────────────────────────────────────────────────────────────┐
 │                      이벤트 루프(Event Loop)                   │
 │─────────────────────────────────────────────────────────────│
 │    준비된 코루틴(Task/Future)들을 queue에 넣고 관리                │
 │─────────────────────────────────────────────────────────────│
 │                                                             │
 │   ① main() 코루틴 시작                                         │
 │   ② task1(), task2() 코루틴 생성 → Task/Future로 감싸짐          │
 │   ③ 이벤트 루프가 이 Task들을 번갈아가며 실행(run)                   │
 │   ④ await asyncio.sleep(n) 만나면:                           │
 │        - 실행을 잠시 중단(suspend)하고 루프에 제어권 반환             │
 │        - “n초 뒤에 다시 깨워줘” 예약                              │      
 │   ⑤ 그동안 다른 코루틴(task2 같은)이 실행될 수 있음                   │
 │   ⑥ 예약된 시간이 되면 이벤트 루프가 다시 코루틴 실행(resume)           │
 │                                                             │
 └─────────────────────────────────────────────────────────────┘
```
- await = “내가 지금 기다려야 하는 작업이 끝날 때까지 이벤트 루프한테 제어권 넘길게”
- 이렇게 하면 이벤트 루프가 다른 코루틴을 돌릴 수 있어서 동시성 효과가 나는 것.

### 비동기 코드 구조
```
import asyncio

async def task1():
    await asyncio.sleep(1)
    print("task1 끝")

async def task2():
    await asyncio.sleep(2)
    print("task2 끝")

async def main():
    await asyncio.gather(task1(), task2())

asyncio.run(main())
```
### 단계별 흐름 (위 코드 기준)
	•	t=0s
	•	main() 실행 → task1, task2 등록
	•	task1 → await sleep(1) 만나서 루프에 제어권 반환
	•	task2 → await sleep(2) 만나서 루프에 제어권 반환
	•	t=1s
	•	루프가 task1 다시 실행 (sleep 끝났으니)
	•	“task1 끝” 출력
	•	t=2s
	•	루프가 task2 다시 실행 (sleep 끝났으니)
	•	“task2 끝” 출력

→ 결과: 1초, 2초 각각 기다리면서도 동시에 돌아가는 것처럼 보임

- 이벤트 루프(Event Loop) : 비동기 작업(Task/Future)을 관리·스케줄링하는 엔진
- 코루틴(Coroutine) : async def로 정의된 함수, awaitable 객체
- await : 해당 코루틴/Future가 끝날 때까지 실행을 잠시 멈추고(Event Loop에 제어권 반환) 다른 작업 수행 가능하게 함
- asyncio.sleep(n) : n초 동안 블로킹 대신 Event Loop에 예약 후 다른 작업을 돌릴 수 있게 함


