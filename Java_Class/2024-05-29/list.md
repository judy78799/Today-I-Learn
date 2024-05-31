list_a = []
list_b = [1,2,3]
list_c = ["Life", "is", "short"]
list_d = [1, 2, "life", "is"]
list_e = [1, 2, ['life', 'is']]

#리스트에서 값을 추출하기
print("리스트의 타입은: ",type(list_a))

print(list_a)
print(list_e)
print(list_d[-1])
print(list_b[0] + list_b[2])
print(list_e[-1])
print(list_e[-1][-1])


#=======================================================

#리스트 slice메서드 사용해보기
#슬라이싱의 결과는? 리스트형으로 나온다.
print(list_c[:2]) #슬라이싱의 결과는? 리스트형으로 나온다.
print(list_d[2:])
print(list_d[2:])
print(list_e[:])
print(len(list_e)) #3
print(len(list_d)) #4


#=======================================================

#리스트 값을 수정해보기

#빈 리스트에는 인덱싱 불가
#list_a[0] = 100 
list_a = 100       #빈 리스트에 숫자를 넣으면 정수형이된다.(리스트X)
print("리스트의 타입은: ",type(list_a))
print(list_a)

#list_a[0] = 200    #error
list_a = [100] 
print("리스트의 타입은: ",type(list_a))     #리스트로 만들기
print(list_a)

#list_a[1] = 200     #error  : list_a는 리스트가 아니기 때문에 1번지가 존재하지 않는다.
print(list_a)


#========================================================
#리스트에 숫자 하나를 추가

list_a.append(300)
print(list_a)


#========================================================
#리스트에 배열을 추가

list_a.append([5,6])
print(list_a)


#========================================================
#리스트를 삭제

del list_a[2][0]
print(list_a) #5


#========================================================
#슬라이싱 지우기

del list_a[2:] #[6]사라짐
print(list_a)


#========================================================
#정렬하기

list_c = ["Life", "is", "short"]
list_c.sort()
print(list_c)


#========================================================
#정렬 뒤집기

list_c.reverse()
print(list_c)

print(list_b[0])
print(list_b.index(1)) #1을 찾아서 첫번째 번지를 반환 1은 0번째에 있음.
print(list_c.index('Life')) 


#insert() : 리스트의 특정 위치에 요소를 삽입하기
print("insert 사용하기 전" ,list_b)
list_b.insert(2,8888) #특정위치, 삽입 요소
print("insert 사용예제" ,list_b)

print(list_b)
list_b.remove(2) #0번째 나오는 2를 삭제해줘
list_b.remove(8888) #1번째 나오는 8888를 삭제해줘
print(list_b)


list_b.insert(2,8888)
print(list_b)
#list_b.remove(8888)
print(list_b)

#========================================================
#pop(n) : 특정 인덱스에 접근하여 데이터를 가져오는 게 가능함.

print("pop하기 전 list_b",list_b)
print(list_b.pop(1))


#========================================================
#count() : 리스트에 포함된 요소의 개수를 반환.

print(list_b)
print(list_b.count(1))
list_b.count(1)

list_b.append(1)
print(list_b.count(1))
print(list_b)


#========================================================
#extend() : 리스트에 리스트를 더해서 확장.

list_b.extend(list_c)
print("리스트 c", list_c)
print("리스트 b 확장하기", list_b)



#========================================================


#예제 Q. [1,3,5,4,2,]리스트를 [5,4,3,2,1]로 만들어보자.

array = [1,3,5,4,2]

array.sort() #정렬 후 reverse
array.reverse()
print(array)


#========================================================


#예제 Q. ["Life", 'is', 'too', 'short']리스트를 붙여보자(띄어쓰기 적용)


a = ["Life", 'is', 'too', 'short']

print(" ".join(a))

result = a[0] + " " + a[1] + " " + a[2] + " " + a[3]
print("result는? : "+result)


# result_1 = a.pop(0)
# print(result_1.append(a[1]))



#반복문 시도...

# a = ["Life", "is", "too", "short"]

# pocket = []

# for i in range(5):
#     pocket += a.pop(0)+" "

# print("pocket의 값은? : ",pocket)


# result3 = ""
# result3 += a.pop(0)+" " # Life
# result3 += a.pop(0)+" " # is
# result3 += a.pop(0)+" " # too
# result3 += a.pop(0) # short
# print(result3)



#예제 Q4. 리스트에서 두번째로 큰 수를 찾는 코드를 작성하시오.


list1 = [1, 5, 3, 4, 15, 99]

# 첫번째 방법
list1.sort()
두번째로큰수 = list1[-2]
print("list1의 값은? : ", list1)
print("list1의 값은? : ", 두번째로큰수)

# 두번째 방법
두번째로큰수 = list1.pop(-2)
print("list1의 값은? : ", 두번째로큰수)



list2 = [1, 5, 3, 4, 15, 99]
list2.remove(max(list1))
print("두번째로큰수 ? : ", max(list2))
