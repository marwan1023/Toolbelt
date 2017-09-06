import numpy as np
import pandas as pd

population_dict = {'California':2, 'Georgia':10, 'New York':8}

population = pd.Series(population_dict)

area_dict = {'California':10000, 'Georgia':5000, 'New York': 3000}

area = pd.Series(area_dict)

states = pd.DataFrame({'population': population, 'area': area})

states_sorted = states.sort_values(['population'],ascending=True)
print states_sorted


#print states.population



