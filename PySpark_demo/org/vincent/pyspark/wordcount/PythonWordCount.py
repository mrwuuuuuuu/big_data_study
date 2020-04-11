from pyspark import SparkContext, SparkConf
import sys

if __name__ == '__main__':
    conf = SparkConf().setAppName("PythonWorldCount").setMaster("local")
    sc = SparkContext(conf=conf)

    result = sc.textFile(sys.argv[1])\
        .flatMap(lambda line: line.strip().split(" "))\
        .map(lambda word: (word, 1))\
        .reduceByKey(lambda a, b: a + b)\
        .collect()

    print(result)
