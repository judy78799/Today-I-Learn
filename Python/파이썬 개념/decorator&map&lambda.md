## ✅ @decorator

### 개념
- `@decorator`는 **데코레이터 함수의 이름**이다.
- 바로 아래에 오는 함수(예: `say_hello`)를 **해당 데코레이터 함수로 감싸는 것**이다.
- 아래 코드는 같은 의미다:

```python
def decorator(func):
    def wrapper():
        print("Before function")
        func()
        print("After function")
    return wrapper

@decorator
def say_hello():
    print("Hello")

say_hello()

# 출력:
# Before function
# Hello
# After function
```

---

## ✅ 제너레이터 (`yield`)

### 개념
- `yield` 키워드를 사용해 만든 **이터레이터**이다.
- 함수 실행 도중 값을 하나씩 반환하고, 상태를 **기억했다가 이어서 실행**한다.
- 리스트보다 메모리를 적게 사용한다.

```python
def number_gen():
    yield 1
    yield 2
    yield 3

gen = number_gen()

print(next(gen))  # 1
print(next(gen))  # 2
print(next(gen))  # 3
# next(gen) → StopIteration 예외 발생
```

### 장점
- 메모리 효율이 좋음
- 무한 반복 구조나 대량 데이터 처리에 유리

---

## ✅ 이터레이터 (Iterator)

### 개념
- `__iter__()`와 `__next__()` 메서드를 가진 객체
- `next()`로 값을 하나씩 꺼낼 수 있다

```python
nums = [10, 20, 30]
it = iter(nums)

print(next(it))  # 10
print(next(it))  # 20
print(next(it))  # 30
# print(next(it)) → StopIteration 예외
```

### 특징
- `iter(Iterable)`로 만들 수 있음
- 값이 모두 소비되면 더 이상 꺼낼 수 없지만, 객체 자체는 여전히 이터레이터임

---

## ✅ 반복 가능한 객체 (Iterable)

### 개념
- `for`문에서 사용할 수 있는 객체
- `iter()` 함수로 이터레이터로 만들 수 있음

```python
for c in "Judy":
    print(c)

# 출력:
# J
# u
# d
# y
```

### 예시
- 리스트, 튜플, 딕셔너리, 문자열, 세트 등은 모두 iterable

---

## ✅ 차이 정리

| 구분       | 설명                                                              |
|------------|-------------------------------------------------------------------|
| Iterable   | `for`문에서 사용할 수 있는 객체 (`list`, `str`, `dict` 등)       |
| Iterator   | `next()`로 값을 하나씩 꺼낼 수 있는 객체                         |
| Generator  | `yield`로 만든 이터레이터. 메모리 효율이 좋고 반복에 적합        |

---

## ✅ 파일 입출력 (`open()`)

### 기본 문법

```python
# 쓰기 모드 ("w"): 기존 파일이 있으면 덮어씀
with open("file.txt", "w") as f:
    f.write("Hello, Judy!")

# 읽기 모드 ("r")
with open("file.txt", "r") as f:
    content = f.read()
    print(content)
```

### 모드 종류

| 모드 | 설명                        |
|------|-----------------------------|
| "r"  | 읽기 전용                   |
| "w"  | 쓰기 전용 (덮어쓰기)        |
| "a"  | 이어쓰기 (파일 끝에 추가)   |
| "r+" | 읽기 + 쓰기                 |
| "wb" | 바이너리 쓰기               |

---

## ✅ map + lambda

### 개념
- `map(함수, iterable)` 형식으로, iterable의 각 요소에 함수를 적용한다.
- `lambda`는 **익명 함수**를 의미한다.

```python
lst = [1, 2, 3]
doubled = list(map(lambda x: x * 2, lst))
print(doubled)

# 출력:
# [2, 4, 6]
```

### 구조 이해

```text
map(함수, 시퀀스) → 시퀀스 각 요소에 함수를 적용
lambda x: x * 2 → 입력값 x를 2배로 만드는 함수
```

---
