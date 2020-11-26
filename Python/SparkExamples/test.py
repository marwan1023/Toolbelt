import random
from pyspark import SparkConf, SparkContext

conf = SparkConf().setMaster("local").setAppName("Pi")
sc = SparkContext(conf = conf)

num_samples = 100000000

def inside(p):     
  x, y = random.random(), random.random()
  return x*x + y*y < 1

count = sc.parallelize(range(0, num_samples)).filter(inside).count()

pi = 4 * count / num_samples
print(pi)

sc.stop()

