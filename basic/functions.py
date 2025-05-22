# def avg():
#     a=int(input("num"))
#     b=int(input("num"))
#     c=int(input("num"))
#     avg = (a+b+c)/3
#     print(avg)

# avg()
# def goodday(name):
#     print("good day, "+name)

# goodday("mukti")
# goodday("riddhi")

# def fact(n):
#     if(n<=1): return 1
#     return n*fact(n-1)

# print(fact(5))
l = ["mukti", "hema", "diya", "aanal", "khushi", "hetvi"]

def fun(l, name):
    n = []
    for i in l:
        if name in i:  # Check if 'name' is in the string 'i'
            n.append(i.strip())  # Strip whitespace from 'i'
    return n

print(fun(l, "a"))  # This will return names that contain 'a'

    
