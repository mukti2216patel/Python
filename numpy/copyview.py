import numpy as np
a = np.array([1,2,3,4,5])
a1 = a.copy()
# copy data is not changed when we change original
# original not change when change copy
a1[0]=11
a[0]=22
print(a1)
print(a)

a = np.array([1,2,3,4,5])
a1 = a.view()

# any change in view or oginal both will get affetcted
a1[0]=11
print(a1 , a)

a[0]=22
print(a1 , a)

import numpy as np

arr = np.array([1, 2, 3, 4, 5])

# copy is not refer to original object so return none 
# y view is connected to original object

x = arr.copy()
y = arr.view()

print(x.base)
print(y.base)

