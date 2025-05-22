import numpy as np
# a = np.array([1,2,3])

# for x in a:
#     print(x)
    
a1 = np.array([[1,2,3] , [4,5,6] , [7,8,9]])

# for i in a1:
#     for j in i:
#         print(j)
# for i in a1:
#     print(i)
    
for i in np.nditer(a1):
    print(i)

# arr = np.array([[[1, 2, 3], [4, 5, 6]], [[7, 8, 9], [10, 11, 12]]])

# for i in arr:
#     for j in i:
#         for k in j:
#             print(k)


arr = np.array([[[1, 2], [3, 4]], [[5, 6], [7, 8]]])

for x in np.nditer(arr[:,::2]):
  print(x)
  
  
  arr = np.array([[1, 2, 3, 4], [5, 6, 7, 8]])

for idx, x in np.ndenumerate(arr):
  print(idx, x)

  
  