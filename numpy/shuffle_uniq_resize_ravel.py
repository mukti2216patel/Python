import numpy as np
a= np.array([1,1,2,3,4,5,2,3,4,5])
a.sort()
print(a)
# shuffle randomly
np.random.shuffle(a)
print(a)

# unique returns new arr
print(np.unique(a))
print(a)


print(np.resize(a ,(3,3)))

# it will repeat elements if size is large
print(np.resize(a,(13,3)))

# flatten the multiarr to one d
arr = np.array([[2,3] , [4,5]])
print(arr.ravel())

