# EntityManager & 영속성 컨텍스트

## JPA
- EntityManager와 영속성 컨텍스트를 통해 데이터의 상태 변화를 감지하고 필요한 쿼리를 자동으로 수행한다.

## EntityManager
- JPA에서 데이터베이스와 상호작용을 위해 사용되는 인터페이스.
- EntityManager는 영속성 컨텍스트를 통해서 데이터베이스와 상호작용하며, JPA의 통신 기능을 추상화한 것.
- EntityManager를 주입받아 JPA를 사용하여 데이터베이스와 상호작용할 수 있게 된다.


### EntityManager가 보이지 않았던 이유 (Spring boot + Spring Data Jpa)
- Application이 시작 -> EntityManager를 자동으로 bean에 등록하기 때문에 우리가 알지 못하는 사이에 가져다 사용하고 있다.


### 출처
https://sjh9708.tistory.com/60#google_vignette [데굴데굴 개발자의 기록:티스토리]
