import numpy as np
a = np.array([1,2,3,4,5])
print(a.dtype)

x = np.array(['s' , 'd' , 'ef'])
print(x.dtype)

a = np.array([1.2 , 3.4 , 5.6] , dtype = 'i')
print(a.dtype)
print(a)

a = np.array([1.2 , 3.4 , 5.6] , dtype = 'S')
print(a.dtype)
print(a)

arr = np.array([1.1, 2.1, 3.1])
newarr = arr.astype('i')
print(newarr)
print(newarr.dtype)


a = np.array([0,2,3,0])
na = a.astype(bool)
print(na)
print(na.dtype)
