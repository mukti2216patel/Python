import numpy as np

# arr = np.array([1, 2, 3, 4, 5, 4, 4])

# x = np.where(arr == 4)
# # return a tuple
# print(x)

# arr = np.array([1, 2, 3, 4, 5, 6, 7, 8])
# x = np.where(arr%2 == 0)
# print(x)

# # There is a method called searchsorted() which performs a binary search in the array, and returns the index where the specified value would be inserted to maintain the search order.
# arr = np.array([6, 7, 8, 9])
# x = np.searchsorted(arr, 7)
# print(x)

# # searching from right side idx is 2 from left it is 1
# x = np.searchsorted(arr, 7, side='right')
# print(x)

# x = np.searchsorted(arr, 7, side='left')
# print(x)

# # Find the indexes where the values 2, 4, and 6 should be inserted:
# arr = np.array([1, 4, 6, 7])
# x = np.searchsorted(arr, [2, 4, 6])
# print(x)

# arr = np.array([2, 4, 6, 7])
# x = np.searchsorted(arr, [2, 4, 6])
# print(x)

arr = np.array([1, 3, 5, 7])
# x = np.searchsorted(arr, [2, 4, 6])
# print(x)

# filter
fa = [True , True , False , False]
new  = arr[fa]
print(new)


arr = np.array([41, 42, 43, 44])
filter_arr = []
for element in arr:
  if element > 42:
    filter_arr.append(True)
  else:
    filter_arr.append(False)
newarr = arr[filter_arr]
print(filter_arr)
print(newarr)

arr = np.array([41, 42, 43, 44])

filter_arr = arr > 42

newarr = arr[filter_arr]

print(filter_arr)
print(newarr)

filter_arr = arr % 2 == 0

newarr = arr[filter_arr]

print(filter_arr)
print(newarr)