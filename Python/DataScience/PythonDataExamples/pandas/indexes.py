import numpy as np
import pandas as pd

indA = pd.Index([1,3,5,7])
indB = pd.Index([2,5,6,7,11])

intersection = indA & indB
union = indA | indB
symDiff = indA ^ indB

print intersection


print union


print symDiff


