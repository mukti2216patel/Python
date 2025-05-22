

from typing import List, Tuple , Dict , Union
n : int = 5
name : str = "mukti"
print(name , n)
def sum(a:int , b: int) -> int :
    return a+b

print(sum(5 , 6))

numbers : List[int] = [1,2,3,4,5]
person : Tuple[str , int] = ("alice" , 30)
score : Dict[str , int] = {"alice" :90 , "me" : 45}

print(numbers)
print(person)
print(score)

def https_st(status):
    match status:
        case 200:
            return "OK"
        case 400:
            return "Bad Request"
        case 500:
            return "internal error"
        case _:
            return "unknown status"

print(https_st(40222))
print(https_st(400))

def main():
    try:
        a = int(input("hey , enter a number :"))
        print(a)
    except ValueError as v:
        print(f"invalid input {v}")
        return
    except Exception as e:
        print(e)
        return
    else :
        print("else")
    finally:
        print("urgent msg")

main()
print("thak you")

l= [12,23,55,3,1]
index=0
for idx , i in enumerate(l):
    print(f"{idx} : {i}")

#  sql = []
# for item in l:
#     sql.append(item*item)
# print(sql)

sql = [i*i for i in l]
print(sql)