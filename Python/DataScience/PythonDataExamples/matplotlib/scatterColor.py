import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import cmaps as colors
import seaborn;

fig = plt.figure()
ax = plt.axes()

plt.title('Scatter Plot')
#plt.set_cmap(colors.viridis)

rng = np.random.RandomState(0)

x = rng.randn(100)
y = rng.randn(100) 

colors = rng.rand(100)
sizes = 1000 * rng.rand(100)

plt.scatter(x, y, c=colors, s=sizes, alpha=0.3, cmap='Blues')
plt.colorbar()

plt.show()

