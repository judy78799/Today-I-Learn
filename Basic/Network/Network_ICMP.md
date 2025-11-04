# ICMP - IP의 한계때문에 등장

### IP의 한계

- 비신뢰성:
패킷이 목적지까지 제대로 전송한다는 보장이 없는 특성
최선형 전달 - 최선을 다해 전달하지만 책임은 지지 않음
- 비연결형 : 호스트 간의 사전 연결 수립이 없는 특성

---

신뢰성 프로토콜, 연결형 프로토콜을 제공하는 계층은 전송계층(TCP)

### TCP

- 신뢰성
- 연결형
=> 전송 계층을 통해 IP의 한계를 극복할 수 있음.

### ICMP -> 비서임

IP의 비신뢰성과 비연결형 특성을 보완하기 위한 네트워크 계층 프로토콜
IP 패킷의 전송 과정에 대한 "피드백 메시지" 제공하는 비서같은 존재

1. 오류보고
2. 네트워크 진단 정보

### ICMP 패킷

- 타입과 코드로 어떤 메시지 인지 정의할 수 있음.

<img width="1900" height="870" alt="image" src="https://github.com/user-attachments/assets/3b75f4af-e3d6-4bd4-bbe1-1523b14a90df" />

1. 오류보고

ICMP 메시지의 타입과 코드 

우리가 많이 봤던 메시지들

- 목적지 도달 불가 Destination Unreachable
- TTL 메시지

<img width="1900" height="1092" alt="image" src="https://github.com/user-attachments/assets/7c5a8364-30a0-49e9-a79f-2848f7c95037" />

ii. 네트워크 진단 정보

<img width="1634" height="678" alt="image" src="https://github.com/user-attachments/assets/60f388b0-537f-424e-8cb1-caf8d155fc21" />

에코 요청 에코 응답

<img width="896" height="838" alt="image" src="https://github.com/user-attachments/assets/2520d6fb-90a1-44c1-9871-cfcd7f1feba0" />

⇒ IP의 한계를 보완할 뿐 완전히 해결된 것은 아니다.
근본적인 해결은 전송 계층에서 이루어짐.
