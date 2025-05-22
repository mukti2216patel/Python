# import imp
import numpy as np 
# print(np.__version__)
# ndarr object
x = np.array([1,2,3,4,5])
print(x)
print(type(x))

# we can pass list , tuple,or any array like object.It will be converted to ndarray
y=np.array((1,2,3,4,5))
print(y)
print(type(y))

# dimensions in arr
# o-d arr - scalars are the elems in array,each value in arr is a 0-d
# now we will create 0-d arr with value 42
x = np.array(24)
print(x)

# 1-d arrays an arr that has 0-d arrays as its elems is called 1-d
me = np.array([1,2,3,4,5,5])
print(x.ndim)
print(me)

x = np.array([[1,2,3] , [4,5,6] , [7,8,9]])
print(x.ndim)
print(x)

x= np.array([[[1,2,3] , [4,5,6] , [7,8,9] , [10,11,12] , [111,222,333]]])
print(x.ndim)
print(x)

# create an arr with 5-d annd verify
x = np.array([1,2,3,4,5,6] , ndmin = 4)
print(x)
print(x.ndim)