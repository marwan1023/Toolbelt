import numpy as np
rand = np.random.RandomState(42)

x = rand.randint(100, size=10)

ind = [2,4,6]

ind = np.array([[3,7],[4,5]])

print x[ind]

x = np.arange(10)
i = np.array([2,1,8,4])
x[i] += 10

print(x)


