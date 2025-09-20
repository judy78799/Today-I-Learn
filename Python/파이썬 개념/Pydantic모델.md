## Pydantic 모델
- Pydantic 모델은 **Python 데이터 유효성 검증(Validation)과 직렬화(Serialization)**를 쉽게 해주는 데이터 모델 클래스.
- FastAPI, LangChain, Chroma 등에서 거의 표준처럼 쓰임.

### 정의
- Pydantic은 Python 타입 힌트를 기반으로 데이터를 검증·변환해주는 라이브러리.
- BaseModel을 상속받아 모델 클래스를 만들면, 들어오는 데이터를 자동으로 유효성 검사 + 타입 변환해 줌.

```
from pydantic import BaseModel

class User(BaseModel):
    id: int
    name: str
    email: str

# JSON → Python 객체
data = {"id": "1", "name": "Judy", "email": "judy@example.com"}
user = User(**data)

print(user)          # id=1 name='Judy' email='judy@example.com'
print(user.id + 1)   # 2  (자동으로 int 변환)
```

### 기능
- 유효성 검증: 필수 필드, 타입, 패턴 등을 자동으로 검증
- 타입 변환: "123" → int 등 자동 캐스팅
- 디폴트 값 지원: Optional과 default 값 설정 가능
- 직렬화: .dict(), .json()으로 쉽게 변환

## 🖥️ FastAPI와 Pydantic 모델
FastAPI에서 Request Body를 정의할 때 Pydantic 모델을 사용.

```
# api/routes/template_routes.py
from fastapi import APIRouter, HTTPException, Depends
from pydantic import BaseModel, Field
from typing import List, Optional, Dict, Any

router = APIRouter(prefix="/template", tags=["Template Generation"])

# --- Pydantic 모델 ---
class GenerationRequest(BaseModel):
    userMessage: str

class GenerationResponse(BaseModel):
    pipeline_success: bool
    error_message: Optional[str] = None
    template_text: str
    template_title: str
    variables: List[str]
    generation_method: str
    message_type: Optional[str]
    category_sub: Optional[str] = None
    category_analysis: Optional[Dict]
    similarity_score: float
    reference_templates: List[Dict]
    pulblic_templates: List[Dict]

```
- Pydantic이 ValidationError를 발생 → FastAPI가 자동으로 422 변환
- 상태코드 422는 **“서버가 요청을 이해했지만, 내용이 유효하지 않아 처리할 수 없음”**을 의미

## 422 에러 JSON 구조
```
{
  "detail": [
    {
      "loc": ["body", "필드명"],
      "msg": "에러 메시지",
      "type": "에러 타입"
    }
  ]
}
```
### 🔹 각 필드 의미
- detail: 에러 상세 목록 (리스트 형태)
- loc: 오류 위치. 예: ["body", "id"] → 요청 body의 id 필드가 문제라는 뜻
- msg: 사람이 읽을 수 있는 에러 메시지 (Pydantic이 생성)
- type: 에러 유형 코드 (예: type_error.integer, value_error.missing)
