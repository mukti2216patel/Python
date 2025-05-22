import numpy as np
x= np.array([1,2,3,4])
print(x[2:])
print(x[:2])
print(x[-3:-1]) 
# 3->-2 2 ->-3
import numpy as np
arr = np.array([1, 2, 3, 4, 5, 6, 7])
print(arr[1:5:2])
print(arr[::2])

arr = np.array([[1,2,3] , [4,5,6] , [7,8,9]])
# from nth row slice
print(arr[1, 1:])
print(arr[2 , 0:2])
print(arr[0,0:1])

# for all row slice 0:3 and return 0 th idx of every row
print(arr[0:3 , 1])

# for two rows slice 1:4
print(arr[0:1, 1:4])

