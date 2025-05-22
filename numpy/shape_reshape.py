import numpy as np

arr = np.array([[1, 2, 3, 4], [5, 6, 7, 8]])
# 2 rows and 4 colms
print(arr.shape)

# reshaping
# from 1d to 2d
arr_1d = np.array([1, 2, 3, 4,5,6,7,8,9,10,11,12])
arr_2d = arr_1d.reshape(3,4)
arr_3d = arr_1d.reshape(3,2,2)
print(arr_2d)
print(arr_3d)

a = np.array([[1,2,3] , [4,5,6] , [7,8,9]])
b = a.reshape(1,9)
print(b)
b = a.reshape(3,3)
print(b)

# change the orginal also
b=a.reshape(3,3).base
b[0]=11
print(b)
print(a)


arr = np.array([1, 2, 3, 4, 5, 6, 7, 8])
newarr = arr.reshape(2, -1, 2)
print(newarr)

arr = np.array([[1, 2, 3], [4, 5, 6]])
newarr = arr.reshape(-1)
print(newarr)
