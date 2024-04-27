# 모던 리액트 딥다이브 week8
# 2024-04-24 DIL

|주차|DIL 범위|날짜|개인 진도|
|------|---|---|---|
| 1주차 | 2-5장 |2024-04-25|888-896p|




# 14. shutdowm 명령어의 옵션에 대한 설명

- -c: 예약된 shutdown 명령을 취소한다.
- -h: shutdown 명령이 완료되면 시스템을 정지시킨다.
- -r: shutdown 명령이 완료되면 시스템을 재부팅한다.  

# 15. ihduser 사용자가 현재 hannam이라는 그룹에 속해있다면 ihduser 사용자의 그룹을 IHD로 변경할 때 알맞은 것은?

: usermod -g IHD ihduser
: usermod -g [변경그룹] [사용자이름]


# 16. reboot 명령어의 수행과정에 대한 설명으로 틀린 것은?










# 22. mount 명령어 옵션

mount: 보조 기억 장치(하드디스크. usb)를 디렉토리처럼 사용할 수 있는 명령어.

## 명령어 사용법:

```
mount [option][device][directory]
```


|option|의미|
|------|----|
| -a | /etc/fstab에 기록되어 있는 모든 파일시스템을 마운트 할 때 사용|
| -t파일시스템_타입 | 파일 시스템의 유형을 지정하는 옵션, 지정하지 않으면 /etc/fstab 참조|
| -o 항목 | 마운트 시 세부적인 옵션을 적용시킬 때 사용 |


# 23. 주 파이션에 대한 설명

- 부팅 가능한 파티션으로 디스크에 하나 이상 존재해야 한다.
- 하나의 디스크에 총 4개까지 사용가능하다.
- 3개 영역으로 파티션 분할할 경우에 주 파티션 내에 설치 가능하다.

# 24. 기본적인 패스워드 설정방법

- 기본적으로 최소 6자 이상이어야 함.
- 특수문자와 숫자 등도 가능함.
- 대, 소문자를 구분함.
- 최초 설정 후 바꿀 수 있음.

# 25. E-IDE 타입의 디스크를 Secondary Slave에 연결했을 경우에 인식하는 장치 (리눅스 하드디스크관리 관련 개념/ 하드디스크 일반.)

- /dev/hdd

### 리눅스에서 사용하는 디스크타입
- SAS 타입
- SATA 타입
- SCSI 타입
- IDE 타입: 
/dev/hda: Primary Master
/dev/hdb: Primary Slave
/dev/hdc: Secondary Master
/dev/hdd: Secondary Slave 
등과 같은 형식으로 장치명을 사용한다.


# 26. 교육용 유닉스로 리눅스 개발의 시발점이 된 운영 체제는?

- Minix


# 27. 명령행에서 입력을 전환할 때 사용하는 기호

- <


![Alt text](image.png)



## 기초 리눅스 용어 암기항목 정리

- sudo: superuser do 슈퍼유저로서 프로그램을 구동할 수 있게 한다.

- pwd(print work directory): 현재 위치하고 있는 디렉토리 표시

-ls(List Segments): 현재 위치해 있는 곳의 파일, 디렉토리의 정보를 제공.pwd와 함께 사용하여 파일의 위치 및 정보를 알아내는데 유용함.

- rm filename 파일제거
- rm -fr filename: 파일 강제 삭제
- touch: 파일 새성하고 타임스탬프 변경
- semange: 보완정책을 추가, 삭제, 변경하는 명령어.
- chown: change owner of file의 약자. 파일의 소유자를 바꿀 수 있다. 보통 슈퍼 사용자가 사용할 수 있으며, 권한이 없는 사용자가 파일의 그룹을 변경하기 위해서는 chgrp를 사용해야 한다.
- chmod: change mode of file: 파일의 권한을 변경할 때 사용하는 명령어.
권한: 읽기(r) ,쓰기(w), 실행(x) 으로 이루어져 있다.

- systemctl: 서버 관리 시 입력하는 명령어이다.

- cd - : 이동하기 직전 디렉토리로 이동.
- cd/dir: 절대경로 dir로 이동.
- cd ~: 어느 곳에서든지 홈 디렉토리로 바로 이동.

- man: 000 manual : 000의 메뉴얼을 확인하고 싶을 때 사용함. 
- 메뉴얼에서 


# 28. 우분투 리눅스 기반이 되는 리눅스

: Devian



===

# 29. groupaddihdl
# groupadd:unabletolockgroupfile

: ihdl 이라는 그룹을 생성하려 하였으나, 권한이 없어서 제대로 실행하지 못하고 있다.


# 30. 