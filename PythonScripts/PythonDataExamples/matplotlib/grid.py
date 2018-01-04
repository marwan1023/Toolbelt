import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn;

fig = plt.figure()
ax = plt.axes()

plt.title('Sin/Cos curves')

x = np.linspace(0, 10, 1000)
ax.plot(x, np.sin(x),color='red',label='sin(x)')
ax.axis('tight')

ax.plot(x, np.cos(x),color='#0000FF', label='cos(x)')
ax.axis('equal')

plt.legend()


plt.show()

