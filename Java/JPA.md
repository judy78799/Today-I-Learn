# JPA(Java Persistence API) -> Interface
## 정의
- 자바 어플리케이션에서 관계형 데이터베이스를 어떻게 사용해야 하는지를 정의하는 방법.
- 즉, 자바 ORM 기술에 대한 API 표준 명세를 의미.
- JPA는 단순 명세. 구현은 javax.persistence 패키지 (interface, Enum, Exception, Anotation들로 이루어져있음)
- JPA를 사용하기 위해서는 ORM 프레임워크를 사용해야 함.(ex. Hibernate)

<img width="1028" height="478" alt="image" src="https://github.com/user-attachments/assets/74a1729d-ecc0-4cec-a3ff-ac17da35a3a3" />

## Hibernate (JPA 인터페이스 구현체 중 하나)
- "메서드 호출을 SQL로 번역하고 실행하는 거대한 ORM 엔진".
- SQL 사용하지 않고 메소드를 사용해 데이터 조작 가능.
- JDBC API 내부적으로 사용함. 지원하는 메소드 중 JDBC API가 동작하고 있음.
<img width="1320" height="378" alt="image" src="https://github.com/user-attachments/assets/e201aa8e-f0b3-4b29-821d-45dae9bec60b" />

### JPA와 Hibernate의 관계
<img width="1302" height="642" alt="image" src="https://github.com/user-attachments/assets/2fe4128c-5b88-4ecb-af47-2a1bd045613e" />

## Hibernate 동작 과정  
- 엔티티 클래스와 데이터베이스 테이블 간의 매핑(Mapping) 정보를 바탕으로
- 메서드 호출 → JPQL → SQL 변환 → JDBC 실행” 단계를 자동으로 수행.

### 1. 메서드 호출(EntityManager → Hibernate)

```
Book book = entityManager.find(Book.class, 1L);
```
- EntityManager는 JPA 표준 인터페이스. 실제 동작은 Hibernate의 구현체(Session) 가 담당.
- entityManager.find() 호출 → 내부적으로 Hibernate의 Session으로 위임.

### 2. 메타데이터 확인 (매핑 정보)

- Hibernate는 애플리케이션 실행 시점에 @Entity, @Table, @Column 같은 애노테이션을 분석해서
- 클래스 <-> 테이블 구조 매핑 정보를 메모리에 저장.

```'
@Entity
@Table(name = "book")
public class Book {
    @Id
    private Long id;

    @Column(name = "title")
    private String title;
}
```

```
Book.class → book 테이블
Book.id → book.id 컬럼
Book.title → book.title 컬럼
```

### 3. 쿼리 생성 (JPQL → SQL 변환)

1. 메서드 호출을 통해 JPQL을 구성

```
select b from Book b where b.id = :id
```
2. 실제 데이터베이스 방언(Dialect, 예: MySQLDialect)에 맞춰
SQL로 변환.

```
SELECT b.id, b.title FROM book b WHERE b.id = ?
```

### 4. JDBC로 SQL 실행
Hibernate는 내부적으로 JDBC API 를 그대로 사용.

```
PreparedStatement pstmt = connection.prepareStatement("SELECT ...");
pstmt.setLong(1, id);
ResultSet rs = pstmt.executeQuery();
```

이 결과를 받아서 Book 객체로 매핑함.
- ResultSet의 각 컬럼 값을 꺼내서
- Book 인스턴스를 생성하고
- 필드에 값 주입 (Reflection 사용)


### 5. 영속성 컨텍스트(Persistence Context)에 저장
Hibernate는 반환된 Book 객체를 1차 캐시(영속성 컨텍스트) 에 저장
같은 트랜잭션 안에서

```
Book book1 = entityManager.find(Book.class, 1L);
Book book2 = entityManager.find(Book.class, 1L);
```
이 두 객체는 하나의 동일한 인스턴스로 관리됨.
즉, DB를 다시 조회하지 않음 (쿼리 한 번만 실행됨).

### Hibernate의 Dirty checking
```
book.setTitle("새 제목");
```
- 이 한 줄만으로 엔티티 값이 바뀌었음을 파악하여
- 트랜잭션 커밋 시, UPDATE 쿼리 날려야 함을 자동으로 판단.


## Hibernate가 find(), save(), delete() 실행 시 구조
- JPA → Hibernate → JDBC → DB” 로 흐르는 전체 구조

### 🧩 Hibernate 내부 동작 흐름 요약도
```
┌──────────────────────────────────────────────────────────────────────────────┐
│                         JPA (EntityManager)                                 │
│   ────────────────────────────────────────────────────────────────────────   │
│   find(), persist(), remove(), merge(), flush() ...                         │
└──────────────────────────────────────────────────────────────────────────────┘
                        │
                        ▼
┌──────────────────────────────────────────────────────────────────────────────┐
│                    Hibernate (ORM Engine)                                   │
│──────────────────────────────────────────────────────────────────────────────│
│  ① 엔티티 매핑 메타데이터 로드                                               │
│     - @Entity, @Table, @Column 분석                                          │
│     - 클래스 ↔ 테이블, 필드 ↔ 컬럼 매핑 정보 보관                            │
│                                                                              │
│  ② 영속성 컨텍스트 (1차 캐시) 관리                                           │
│     - 이미 조회한 엔티티 캐싱                                                │
│     - 동일 트랜잭션 내 동일 ID 객체 재사용                                   │
│                                                                              │
│  ③ 변경 감지 (Dirty Checking)                                               │
│     - flush 시점에 스냅샷과 현재 상태 비교                                    │
│     - 변경된 필드가 있으면 UPDATE SQL 생성                                   │
│                                                                              │
│  ④ JPQL → SQL 변환                                                          │
│     - find()  → SELECT                                                       │
│     - persist() → INSERT                                                     │
│     - remove() → DELETE                                                      │
│     - merge() → SELECT + UPDATE                                              │
│                                                                              │
│  ⑤ flush 타이밍                                                             │
│     - 트랜잭션 커밋 직전 자동 flush                                          │
│     - 또는 명시적 entityManager.flush()                                      │
└──────────────────────────────────────────────────────────────────────────────┘
                        │
                        ▼
┌──────────────────────────────────────────────────────────────────────────────┐
│                           JDBC API                                           │
│──────────────────────────────────────────────────────────────────────────────│
│  - PreparedStatement 생성                                                     │
│  - SQL 실행                                                                  │
│  - ResultSet → 객체 매핑 (Reflection)                                        │
└──────────────────────────────────────────────────────────────────────────────┘
                        │
                        ▼
┌──────────────────────────────────────────────────────────────────────────────┐
│                           데이터베이스                                       │
│──────────────────────────────────────────────────────────────────────────────│
│  - 실제 SQL 실행                                                             │
│  - 트랜잭션 커밋 / 롤백                                                      │
└──────────────────────────────────────────────────────────────────────────────┘
```

## 요약
|단계|Hibernate 내부 동작|
|---|---|
|1. 메서드 호출|JPA → Hibernate Session 위임|
|2. 매핑 분석|엔티티 ↔ 테이블 메타데이터 확인|
|3. 쿼리 빌드|JPQL 생성 → SQL로 변환|
|4. 실행|JDBC를 통해 SQL 실행|
|5. 캐싱|영속성 컨텍스트에 저장 및 관리|

즉, Hibernate의 핵심은 JPQL을 SQL로 번역해주는 쿼리 빌더 엔진.
