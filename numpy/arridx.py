import numpy as np
x = np.array([1,2,3,45,5])
print(x[0])
print(x[3] + x[4])

x=np.array([[1,2,3] , [4,5,6] , [7,8,9]])
print(x[0][1])
print(x[1][1])

x = np.array([[[1,2,3] , [4,5,6]] , [[11,22,33] , [44,55,66]]])
print(x[0][0][1] , x[1][0][1])
print(x[0,0,1] , x[1,0,1])


