# EntityManager & 영속성 컨텍스트

## JPA
- EntityManager와 영속성 컨텍스트를 통해 데이터의 상태 변화를 감지하고 필요한 쿼리를 자동으로 수행한다.

## EntityManager
- JPA에서 데이터베이스와 상호작용을 위해 사용되는 인터페이스.
- EntityManager는 영속성 컨텍스트를 통해서 데이터베이스와 상호작용하며, JPA의 통신 기능을 추상화한 것.
- EntityManager를 주입받아 JPA를 사용하여 데이터베이스와 상호작용할 수 있게 된다.


### EntityManager가 보이지 않았던 이유 (Spring boot + Spring Data Jpa)
- Application이 시작 -> EntityManager를 자동으로 bean에 등록하기 때문에 우리가 알지 못하는 사이에 가져다 사용하고 있다.

### Repository의 EntityManager 의존성 주입
1. [Spring 3.x ~ 4.x 초반까지] @PersistenceContext 사용 (JPA 표준 방식)
: @PersistenceContext는 JPA 컨테이너가 관리하는 영속성 컨텍스트를 주입하기 위한 전용 애노테이션.

```
@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;


    public void save(Member member){
        em.persist(member);
    }
    
 }
```

2. [Spring 4.3 ~이후] @Autowired 어노테이션으로 주입
: Spring 4.3부터 스프링 프레임워크가 JPA의 EntityManager를 일반적인 스프링 빈처럼 자동 주입(@Autowired) 가능하도록 확장.

```
@Repository
public class MemberRepository {

    @Autowired
    private EntityManager em;

    
    public void save(Member member){
        em.persist(member);
    }
    
 }
```
- 내부적으로는 여전히 @PersistenceContext를 사용하는 것과 같은 동작을 수행
- Spring이 자동으로 감지해서 EntityManagerFactory → EntityManager를 주입받은 SimpleJpaRepository 구현체를 만들어, 프록시로 대신 등록해주기 때문.


|구분|순수 JPA(javax.persistence)|Spring Data JPA|
|---|---|---|
|EntityManager 주입|@PersistenceContext|자동 주입 @Autowired(내부에서 관리)|
|Repository 구현|직접 작성|인터페이스만 작성|
|주입대상|EntityManager (Proxy로 관리됨)|EntityManager (Spring이 JPA 컨텍스트에서 꺼내줌)|
|쿼리 실행|em.find(), em.persist()|findById(), save(), delete()|
|런타임 구현체|직접 클래스 작성|SimpleJpaRepository 프록시 자동 생성|

### 출처
https://sjh9708.tistory.com/60#google_vignette [데굴데굴 개발자의 기록:티스토리]
