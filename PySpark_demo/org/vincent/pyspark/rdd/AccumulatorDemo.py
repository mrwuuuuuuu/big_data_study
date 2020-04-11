from pyspark import AccumulatorParam, SparkConf, SparkContext, RDD, Accumulator


class MyAccumulator(AccumulatorParam):
    def zero(self, value):
        return value

    # 只对偶数累加
    def addInPlace(self, value1, value2):
        if value2 % 2 == 0:
            return value1 + value2
        return value1


def evenSum(accum: Accumulator, rdd: RDD):
    print(rdd.collect())
    rdd.foreach(lambda x: accum.add(x))
    print("sum-->%d" % accum.value)


if __name__ == '__main__':
    conf = SparkConf().setMaster("local[*]").setAppName("RddDemo")
    sc = SparkContext(conf=conf)
    data = [1, 2, 2, 5, 6, 7, 3, 5, 6, 7, 8, 9]
    rdd1 = sc.parallelize(data, 3)
    accum = sc.accumulator(0, MyAccumulator())
    evenSum(accum, rdd1)

