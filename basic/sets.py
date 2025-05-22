# dict = {"key" , value} tupple=(13,23) list = ["enfn" , 23]
s = {2,3,5,6,1,1,1,1,1 , "harry"}

# set only take one ocr of element ordered is also sorted
print(s , type(s))

# to create empty set dont use s={} this create empty dict
e = set()
print(e)

# to add single ele
s.add(23.2222)
print(s)

# to add multiple ele
s.update([11 , 22 , 33])
print(s)

# this will remove ele if it finds
# but it will give error if it not found
s.remove(11)
print(s)

# discard same as remove but will not give error 
# if not find ele
s.discard(2333)

# remove randon ele return removed ele
s.pop()
print(s)

s1 = s.copy()
print(s1)

# set operations
seta = {1,2,3}
setb={4,5,6}

# union // merge all ele of both sets
setc = seta.union(setb)
print(setc)
setc = seta | setb
print(setc)

# intersection // commom ele
setc = seta.intersection(setb)
print(setc)
setc = seta & setb
print(setc)

# difference
setc = seta.difference(setb)
print(setc)
setc =  setb - seta
print(setc)

# check if ele is in set or not
print(4 in setc)

# check if it is subset of set or not
print(setb.issubset(setc))

setc.clear()
print(setc)

# sets are unordered ,unindexed ,unindexed
# cannot contain duplicate elems

print(len(s))
s.remove(2)
print(s)
