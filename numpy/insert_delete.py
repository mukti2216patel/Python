import numpy as np

a = np.array([1,2,3,4,5])
print(a)

# arr , idx , value
# for md arr , idx ,val , axis
print(np.insert(a , 0 , 11))
print(np.delete(a , 0))
print(a)

# not changing original one 
a = np.array([[1,2] , [3,4] , [5,6] , [7,8]])
print(np.insert(a , 1 , [50,40] , axis=0))
print(np.delete(a , 1 , axis = 1 ))
print(np.delete(a , 1 , axis = 0 ))