# Spring Data JPA
## 정의
- Spring Data JPA는 "JPA를 감싼 추상화"
- JPA(Hibernate)의 복잡한 코드(엔티티매니저, JPQL 등)를 감싸서
CRUD를 자동으로 해주는 “생산성 도구”.
- 단순 CRUD 중심의 서비스에 최적.

## 단점
- JPA의 핵심 로직(영속성 컨텍스트, flush 타이밍, 지연 로딩 등)을 자동으로 처리.
- 언제, 왜, 어떤 쿼리가 나가는지 예측하기 어려워짐.

---

### 단점 1) 추상화가 과해 제어 불가능
코드 예시

```
bookRepository.findAll(); // N+1 쿼리 폭탄
```

- 내부에서 Lazy Loading + Join 이슈가 발생하고,
- 트랜잭션 경계를 잘못 잡으면 LazyInitializationException,
- 캐시 정리 안 하면 flush 타이밍 꼬임.

결국 “단순한 코드”가 “성능 지옥”이 됨.

### 단점 2) 쿼리 제어가 힘듦
- 복잡한 조인, 동적 조건, 페이징, 집계 쿼리 등이 들어오면 결국 JPQL이나 QueryDSL로 내려가야 함.
- 자동화의 한계점.

코드 예시
```
List<Book> findByAuthorAndPublisherAndCategoryAndPriceBetween(...);
```

### 단점 3) 영속성 컨텍스트의 부작용

- Spring Data JPA는 모든 save(), find()가 EntityManager의 1차 캐시에 연결되어 동작함.
- 동시성이나 대량 데이터 처리 시 flush, clear, dirty checking 제어가 어려움.

대표적인 문제:
- 벌크 업데이트 시 1차 캐시 미반영 → 데이터 불일치
- saveAll() 사용 시 batch insert 미적용
- detach, merge 시 타이밍 꼬여서 데이터 꼬임

### 단점 4) Lazy Loading 지옥
