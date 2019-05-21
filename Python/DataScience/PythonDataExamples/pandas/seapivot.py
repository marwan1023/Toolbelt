import numpy as np
import pandas as pd
import seaborn as sns

sns.set()

def make_df(cols, ind):
  data = {c: [str(c) + str(i) for i in ind]
         for c in cols}
  return pd.DataFrame(data, ind)

titanic = sns.load_dataset('titanic')


print titanic.head()

survived = titanic.pivot_table('survived', index='sex', columns='class')

age = pd.cut(titanic['age'], [0,18,80])
survived = titanic.pivot_table('survived', ['sex',age],'class')

print survived


 








