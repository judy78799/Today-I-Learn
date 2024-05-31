
a = "hello, i'm spppongebob;"
print("문자열 hello, i'm spppongebob;", a.count('p'));
print("문자열 hello, i'm spppongebob;", a.find('b'));


## find() : 첫번째 문자열 위치 반환
print(a.find('b'));


#================================================================

## join() : 문자열 삽입

#b = "".join(a); #띄어쓰기 적용X
#b = " ".join(a); #띄어쓰기 적용
b = "-".join(a);
print("join을 사용한다면",b);

## upper() : 대문자 변환
print(a.upper());



#================================================================

## lower() : 소문자 변환
c = " HELLO ";
print(c.lower());

## strip() : 공백제거(l:left/r: right)
print(c.lstrip());
print(c.rstrip());
print(c.strip());


#================================================================

## split() : 문자열 분리/ 분리된 문자열은 리스트로 반환
## 문자열 사이에 공백이 있어야 적용됨
c = "Life is too short";
print("c를 split으로 나누면? ", c.split());
print("c를 split으로 나누면2? ",c.split(','));


#================================================================

## replace()

print(b);
print(b.split(","));


pin="881120-1068234"
yymmdd = pin.split('-') #['881120', '1068234']
생년월일 = yymmdd[0] #['881120']
yy = 생년월일[0:2] #88
mm = 생년월일[2:4] #
dd = 생년월일[4:6] #

print("한정교씨는 19",yy,"년", mm,"월", dd, "일입니다.");
#print(yy[0:5]);
#print("한정교씨는" + yymmdd[0]년 + 월 %일 입니다." );
# 한정교씨는 1988년 몇월 몇일입니다.


#================================================================
# : 를 #으로 바꾸기

a="a:b:c:d"

b = a.replace(':','#')
print(b)


#================================================================

# replace로 공백 없애고 join으로 # 끼어넣기
b = a.replace(':','')
c = "#".join(b);

print("replace으로 공백 없애기",b);
print("join을 사용한다면2",c);


#================================================================

# split으로 자르고 다시 #으로 붙이기

split = a.split(':') #['a', 'b', 'c', 'd']
split2= "#".join(split) #'#'으로 자르기

print("split으로 자르기",split); 
print("다시 #으로 붙이기",split2); 


#================================================================

#첫번째 문제풀이
# divmod 메서드 사용: 몫과 나머지 한번에 구할 수 있는 메서드 입니다.


changes = 758

### 500원 몫과 나머지 구하기
won500, won500_changes = divmod(changes,500)
print(won500, won500_changes)

### 100원 몫과 나머지 구하기
won100, won100_changes = divmod(won500_changes,100)
print(won100, won100_changes)

### 50원 몫과 나머지 구하기
won50, won50_changes = divmod(won100_changes,50);
print(won50, won50_changes);

### 10원 몫과 나머지 구하기
won10, total_changes = divmod(won50_changes,10);
print("바꾸지못한잔돈은? : ", total_changes);



print("================================");


#두번째 문제풀이
#================================================================

won500 = 758//500; #500원 몫 구하기
won500last =  758%500; #500원 나머지 구하기
print("500원 몫: ",won500,"개");
print("500원 나머지: ",won500last,"원\n");

won100 = won500last//100; #100원 몫 구하기
won100last = won500last%100; #100원 나머지 구하기
print("100원 몫: ",won100,"개");
print("100원 나머지: ",won100last,"원\n");

won50 = won100//50; #50원 몫 구하기
won50last = won100last%50; #50원 나머지 구하기
print("50원 몫: " ,won50,"개");
print("50원 나머지: ",won50last,"원\n");

won10 = won50//10; #10원 몫 구하기
won10last = won50last%10; #10원 나머지 구하기
print("10원 몫: ",won10,"개");
print("바꾸지 못한 잔돈은? : ",won10last,"원");



#================================================================


#선생님이 푼 문제풀이

money = 758;

won500 = money//500; #500원 몫 구하기
money %= 500; #500원 나머지 구하기
print("500원 몫: ",money,"개");
print("500원 나머지: ",money,"원\n")

won100 = won500last//100; #100원 몫 구하기
won100last = won500last%100; #100원 나머지 구하기
print("100원 몫: ",won100,"개")
print("100원 나머지: ",won100last,"원\n")

won50 = won100//50; #50원 몫 구하기
won50last = won100last%50; #50원 나머지 구하기
print("50원 몫: " ,won50,"개")
print("50원 나머지: ",won50last,"원\n")

won10 = won50//10; #10원 몫 구하기
won10last = won50last%10; #10원 나머지 구하기
print("10원 몫: ",won10,"개")
print("바꾸지 못한 잔돈은? : ",won10last,"원")



# 강사님 코드 
# Q6. 일정 금액을 500, 100, 50, 10원의 동전으로 교환하는 프로그램을 작성해보자. 변수 선언 하기
money = 758

# 교환할 동전을 금액별로 계산하여 변수에 넣기
c500 = money // 500
money %= 500    # money %= 500

c100 = money // 100
money %= 100    

c50 = money // 50
money %= 50

c10 = money // 10
money %= 10


# 계산이 끝나면 금액별로  출력하기
print(" 500원 짜리 ==> " + str(c500) + "개" )
print(" 100원 짜리 ==> %d개" %c100)
print(" 50원 짜리 ==> %d개" %c50)
print(" 10원 짜리 ==> %d개" %c10)
print(" 바꾸지 못한 잔돈 ==> %d원" %money)


# 진아님 코드

# 일정 금액을 500,100,50,10원의 동전으로 교환하는 프로그램을 작성해보자
mon=int(input("교환할 돈을 입력하세요 : ")) #input 사용시 문자형으로 변형됨
ch=int(mon%1000)

ob=int(ch/500)
ob1=int(ch%500)

bac=int(ob1/100)
bac1=int(ob1%100)

os=int(bac1/50)
os1=int(bac1%50)

ss=int(os1/10)
ss1=int(os1%10)

print("1000원짜리",str(mon//1000),"개")
print("500원짜리",str(ob),"개")
print("100원짜리",str(bac),"개")
print("50원짜리",str(os),"개")
print("10원짜리",str(ss),"개")
print("바꾸지 못한 잔돈",str(ss1),"원")




#==================================


#a[-1]은 a 리스트의 마지막 요소값

a = [1,2,3,['a','b','c']]

a[-1][0] #

#파이썬은 리스트 값을 쉽게 바꿔줄 수 있다. 따로 메서드 사용 없이 바꾼다.


# del()리스트 요소 삭제
del a[0]


#append()리스트의 맨 마지막에 요소 추가

a.append(2)


#sort(): 리스트의 요소를 순서대로 정렬/ 사전순

a = [1,2,3,4]
a.sort()

#reverse(): 리스트의 요소를 역순으로 정렬
