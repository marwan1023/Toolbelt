import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn;

x = np.linspace(0, 10, 100)
fig, ax = plt.subplots(2)


ax[0].plot(x, np.sin(x))
ax[1].plot(x, np.cos(x))

plt.show()

