# 네트워크 계층

물리 계층과 데이터링크 계층 → LAN에 국한된 통신
LAN을 넘어서기 위한 계층
네트워크 간 통신이 가능한 계층 -> 라우팅
(IP라는 프로토콜을 통해) 단편화가 이루어지는 계층

데이터링크 계층의 MAC 주소도 있는데? 굳이 IP 주소를 사용한 이유

- 도달 경로를 파악하기 어려움(라우팅 어려움)
- 임의의 네트워크에 속한 호스트의 MAC 주소를 기억하기 어려움
- MAC 주소 == 주민등록 번호

기본적으로 MAC 주소 이전에 IP 주소를 사용

- MAC 주소 수취인 개인 정보(eg. 주민등록번호) -> 물리주소 (변경 X)
- IP 주소 수취인 주소(eg. 서울특별시 노원구...) -> 논리주소 (쉽게 변경 가능)
- 보통 IPv4 버전의 주소를 사용.
- 직접 할당 가능
- 자동 할당 (DHCP)

# IP

단편화

- 패킷의 크기를 MTU(Maximum Transmission Unit) 이하로 유지
- MTU 크기 이하로 단편화된 패킷들은 목적지에서 재조합
<img width="1184" height="444" alt="image" src="https://github.com/user-attachments/assets/d7ee27be-4d24-427c-bc0a-ada7f8be5a0e" />



## IPv4 헤더

<img width="826" height="762" alt="image" src="https://github.com/user-attachments/assets/680e7285-f7b6-4b48-8c98-fd4c49baa711" />

### 식별자, 플래그, 단편화 오프셋

- 식별자 : 패킷에 할당된 번호(재조합 시 사용)
- 플래그 : 부가정보(미사용, Don’t Fragment, More Fragment)
- 단편화 오프셋 : 단편화 되기 전 데이터가 얼마나 떨어져 있는가

### TTL, 프로토콜, 헤더 체크섬

- 패킷의 수명 : 라우터를 거칠 때마다 -1씩 감소

<img width="1476" height="528" alt="image" src="https://github.com/user-attachments/assets/e1fd6a6c-c95e-40e8-9756-9c677e45e744" />


- 프로토콜 : 상위 계층의 프로토콜

## IPv4 → IPv6

### IPv4

- 4바이트(32 비트)로 표현 가능
- 한 옥텟은 0 ~255 범위의 네 개의 십진수로 표기
- 이론적으로 할당 가능한 IPv4 주소 개수 == 2^32개 ← 넉넉한 양이 아님

⇒ IP주소 부족 문제

### IPv6

- 16바이트(128 비트)로 표현 가능
- 이론적으로 할당 가능한 IPv4 주소 개수 == 2^128개 ← 사실상 무한
