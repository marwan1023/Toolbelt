import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn;

seaborn.set()
data = pd.read_csv('height.csv')
heights = np.array(data['height(cm)'])

print (heights)
max = heights.max()
std = heights.std()

print ("Standard Dev: " + str(std))
print ("Max: " + str(max))
print ("90th percentile: ", np.percentile(heights, 90))

plt.hist(heights)
plt.title('Height Distribution of US Presidents')
plt.xlabel('height (cm)')
plt.ylabel('number')
plt.show()

