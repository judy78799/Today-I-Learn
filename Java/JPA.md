# JPA(Java Persistence API) -> Interface
## 정의
- 자바 ORM 기술에 대한 API 표준 명세를 의미.
- ORM을 사용하기 위한 인터페이스를 모아둔 것.
- 즉 자바 어플리케이션에서 관계형 데이터베이스를 어떻게 사용해야 하는지를 정의하는 방법.
- JPA는 단순 명세. 구현은 javax.persistence 패키지 (interface, Enum, Exception, Anotation들로 이루어져있음)
- JPA를 사용하기 위해서는 ORM 프레임워크를 사용해야 함.(ex. Hibernate)

<img width="1028" height="478" alt="image" src="https://github.com/user-attachments/assets/74a1729d-ecc0-4cec-a3ff-ac17da35a3a3" />

## Hibernate (JPA 구현체 중 하나)
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

즉, Hibernate의 핵심은 JPQL을 SQL로 번역해주는 쿼리 빌더 엔진.
