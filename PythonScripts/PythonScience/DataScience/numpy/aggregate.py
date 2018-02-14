import numpy as np

np.random.seed(0)

def compute_reciprocals(values):
  output = np.empty(len(values))
  for i in range(len(values)):
     output[i] = 1.0 / values[i]
  return output

values = np.random.randint(1, 10, size=5)
result = compute_reciprocals(values)

print(np.min(result))
print(np.max(result))

M = np.random.random((3,4))
print M

print(M.min(axis=0))




print(np.multiply.reduce(M))
