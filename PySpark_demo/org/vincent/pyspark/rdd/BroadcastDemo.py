from pyspark import SparkConf, SparkContext

if __name__ == '__main__':
    conf = SparkConf().setMaster("local[*]").setAppName("RddDemo")
    sc = SparkContext(conf=conf)
    data = [1, 2, 2, 5, 6, 7, 3, 5, 6, 7, 8, 9]
    bcVal = sc.broadcast(data)
    print(bcVal.value)
