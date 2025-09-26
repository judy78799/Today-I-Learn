# 개념
- Abstract Base Classes
- Type Hints 
- Async/Await 패턴


## 1. Abstract Base Classes
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


## 타입 힌트
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





