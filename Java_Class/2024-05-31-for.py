#================================================================
#for i 연습
# test_list = ['one' , 'two', 'three']
# for i in test_list:
#     print(i)




#================================================================
#3의 배수

# result = 0
# i = 1
# for i in range(1001):
#     if i % 3 == 0:
#         result += i
# print(result)


# result = 0
# i = 1 #1부터 1000까지 반복
# while i <= 1000:
#     if i % 3 == 0:
#         result += i
# print(result)


#================================================================
# add = 0
# for i in range(1,11):
#     add = add + i

# print(add)


# marks = [90,25,67,45,80]

# for number in range(len(marks)):
#     if marks[number] < 60:
#         continue
#     print("%번 학생 축하합니다. 합격입니다." % (number+1))


#구구단 출력

# for i in range(2,10): #2~9단까지 반복
#     for j in range(1,10): #1~10까지 반복
#         print(i * j) #




#================================================================
#리스트를 for 반복문 출력

# test_list = ['one','two','three']

# for i in test_list:
#     print(i)


# print(range(100))
# print(range(1,100))



#================================================================
# for문을 사용해 1부터 1000까지의 합을 출력해보자.

# sum = 0
# for i in range(1,1001):
#     sum += i

# print(sum)



#================================================================

# sum = 0
# a = [70,60,55,75,95,90,80,80,85,100]

# for i in range(len(a)):
#     sum += a[i]

# print("평균은 ? : " , (sum/len(a)))


# #================================================================
# score_dic = {
#     "Kim":[99,88,95], #kim안의 것 합
#     "Lee":[99,88,95],
#     "Han":[99,88,95],
# }
# kim = score_dic.get("Kim")
# print("kim의 값은? :", kim)


# sum = 0
# # Kim = score_dic["Kim"]
# # Lee = score_dic["Lee"]
# # Han = score_dic["Han"]

# all = score_dic.items()
# # all_values = score_dic.items()

# score_dic.get(score_dic)


# for i in range(len(all)):
#     sum += all[i]


# print("sum은? : ",sum)
# print('Kim의 sum은? :',sum /len(score_dic))
# print('Lee의 sum은? :',sum /len(score_dic))
# print('Han의 sum은? :',sum /len(score_dic))
# # sum = 0

# for i in range(len(list2)):
#     sum += score_dic[i]

# # avg = sum/len(list2)
# print("평균은? : ", sum)

# sum = 0

score_dic = {
    "Kim":[99,88,95], #kim안의 것 합
    "Lee":[68,85,99],
    "Han":[85,96,76],
}



for name,scores in score_dic.items():
    avg = sum(scores)/len(scores)
    # print("학생의 이름은? : ",name,"학생의 평균 성적은? :",scores/len(scores))
    print(name,"의 평균 성적은? :", avg)

    if(avg >= 60):
        print("축하합니다")
    else:
        print("메시지 없음")



#=================================================================
#60점 이상인 사람에게는 축하메시지, 나머지에게는 아무런 메시지도 전하지 말아라
marks = [90,25,67,45,80]

number = 0

for i in marks:
    number += 1
    if(i >= 60):
        print(number,"번째 학생 축하합니다")
    else:
        print("메시지 없음")



# 구구단 만들기  -- 난 왜 밀려서 나오지??
i = 1
print("-" * 115)
for i in range(1,10):
    # print(i,"단 구구단")
    for j in range(2,10):
        
        print(j, "X" , i, "=", i * j ,end=" ")
    print(" ")
        

    # print("\n")    # 한 구구단이 끝나는 지점
    
    
