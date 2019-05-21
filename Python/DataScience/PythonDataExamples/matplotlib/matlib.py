import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn;

x = np.linspace(0, 10, 100)
plt.figure()

plt.subplot(2, 1, 1)
plt.plot(x, np.sin(x))

plt.subplot(2, 1, 2)
plt.plot(x, np.cos(x))

plt.show()

