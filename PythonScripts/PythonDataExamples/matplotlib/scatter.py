import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn;

fig = plt.figure()
ax = plt.axes()

plt.title('Scatter Plot')

x = np.linspace(0, 10, 30)
y = np.sin(x)

#ax.plot(x, y,'-ok', color='black')
ax.scatter(x, y, marker='o')
ax.axis('equal') 

plt.show()

