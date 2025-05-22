marks = {
    "mukti" : 27,
    "hema" : 29,
    "diya" : 34,
    "Aanal" : 43
}
print(marks, type(marks))
# give error
# print(marks(0))
print(marks["hema"])
# list will take more time to search but dict take very less time
# it is unordered , mutable,indexed
print(marks.get("hema"))
print(marks["hema"])
marks["hema"]=23
print(marks)
marks.pop("hema")
print(marks)
del marks["mukti"]
print(marks)

keys = marks.keys()
print(keys)
values=marks.values()
print(values)

print("diya" in marks)

newm = marks.copy()
newm.update({"diya" : 399})
print(newm)
