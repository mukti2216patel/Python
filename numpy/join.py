import numpy as np
a = np.array([1,2,3])
b=np.array([3,4,5])
c = np.concatenate((a , b))
print(c)
c = np.stack((a,b) , axis = 1)
print(c)



import numpy as np

a = np.array([[1, 2],    # Shape (2, 2)
              [3, 4]])
b = np.array([[5, 6],    # Shape (2, 2)
              [7, 8]])

# Concatenating along axis 0
# c = np.concatenate((a, b), axis=0)
# print(c)

# Concatenating along axis 1
# c = np.concatenate((a, b), axis=1)
# print(c)

c = np.stack((a,b) , axis = 1)
print(c)

c = np.vstack((a,b))
print(c)

c = np.hstack((a,b))
print(c)


