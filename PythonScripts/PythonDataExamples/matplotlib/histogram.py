import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn;


data = np.random.randn(1000)
plt.hist(data)
plt.title('Histogram')

#ax = plt.axes(axisbg='#e6e6e6')
#ax.set_axisbelow(True)

plt.grid(color='w', linestyle='solid')


plt.show()

