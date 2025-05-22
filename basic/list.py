fruits = ["apple" , "orange" , 23.33 , 23 , False,"mukti"]
print(fruits[0][2])
fruits[0]="friends"
print(fruits[0]) 
# lists are mutable
print(fruits[0:2])
print(fruits[1][0:3])

fruits.append("name")
# insert at 1 index value 21.11
fruits.insert(1,21.111)
fruits.pop(2)
print(fruits)

l1 = [1,22,34,12,35]
l1.sort()
print(l1)
l1.reverse()
print(l1)
l1.remove(1)
print(l1)
# printing sum
print(sum(l1))