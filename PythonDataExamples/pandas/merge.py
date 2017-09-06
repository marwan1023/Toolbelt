import numpy as np
import pandas as pd

def make_df(cols, ind):
  data = {c: [str(c) + str(i) for i in ind]
         for c in cols}
  return pd.DataFrame(data, ind)


dataFrame1 = make_df('DEF', [1,2])
#print dataFrame1

dataFrame2 = make_df('DEF', [3,4])
#print dataFrame2


#print pd.concat([dataFrame1, dataFrame2])
combineFrame = dataFrame1.append(dataFrame2)

newFrame = make_df('DEF', range(4))
print pd.merge(combineFrame,newFrame)





