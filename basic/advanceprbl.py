try: 
    with open("1.txt" , "r") as f:
        print(f.read())
except Exception as e:
    print(e)
try:
    with open("2.txt" , "r") as f:
        print(f.read())
except Exception as e:
    print(e)
try:
    with open("3.txt" , "r") as f:
        print(f.read())
except Exception as e:
    print(e)
    
print("thank you")


l = [1,2,3,4,5,6,7,8,9]
for idx,i in enumerate(l):
    if idx== 2 or idx ==4 or idx==6:
        print(i)

n= 5
table = [n*i for i in range(1,11)]
print(table)

try:
    a = int(input("enter a :"))
    b=int(input("enter b :"))
    print(a/b)
except ZeroDivisionError as v:
    print("Infinite")

n= 5
table = [n*i for i in range(1,11)]
with open("table.txt" , "a") as f:
    f.write(str(table) + "\n")
    
print(table)
