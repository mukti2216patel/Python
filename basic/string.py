a='''hfncifc'''
print(a)
str1 = a[-4:-1]
print(str1)
str1=a[1:4]
print(str1)
str1=a[1:]
print(str1)
str1=a[:4]
print(str1)

ch = a[1]
print(ch)

a="0123456789"
name = a[1:7:3] 
#  start fromt 1 jump 3 
print(name)

a = "fncdwoihcnf"
print(len(a))
print(a.endswith("cnf"))
print(a.startswith("aaaa"))
# first letter capitalze
print(a.capitalize()) 
print(a.upper())
print(a.lower())
print(a.count("f"))
print(a.find("cnf"))
print(a.replace("cnf" , "good"))

a = "m\nu\"k\nti\n"
print(a)

name = "mukti"
print(f"good morning {name}")

letter = "dear name your selected at date"
print(letter.replace("name" , "mukti").replace("date" , "12 sept 2050"))

