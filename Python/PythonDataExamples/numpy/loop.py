import numpy as np

np.random.seed(0)

def compute_reciprocals(values):
  output = np.empty(len(values))
  for i in range(len(values)):
     output[i] = 1.0 / values[i]
  return output

values = np.random.randint(1, 10, size=5)
print(1.0/values)
result = compute_reciprocals(values)
print(np.add.reduce(result))
print(np.multiply.reduce(result))
print(np.multiply.accumulate(result))
