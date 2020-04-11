import uuid
from pyspark import SparkConf, SparkContext


# 读取外部数据集
def readfile(sc: SparkContext):
    rdd1 = sc.textFile("../../../../file/data.csv")
    print(rdd1.take(1))


# 读取并行数据集
def readParallelizedCollections(sc: SparkContext):
    data = [1, 2, 34, 5, 6, 7]
    rdd1 = sc.parallelize(data, 2)
    print(rdd1.take(1))
    print(rdd1.getNumPartitions())


# 合并小文件
def mergeFile(sc: SparkContext):
    uid = uuid.uuid1()
    rdd = sc.wholeTextFiles("../../../../file")
    result = rdd.map(lambda item: item[1])
    result.saveAsTextFile("../../../../file/merge_file_%s" % uid)
    return result.cache()


def fun(s: str):
    print("--->" + s)
    words = s.split(" ")
    return len(words)


# 统计所有文件中的单词数量
def countWord(rdd):
    result = rdd.map(lambda line: ("wordNum", fun(line))).reduceByKey(lambda a, b: a + b).collect()
    print(result)


if __name__ == '__main__':
    conf = SparkConf().setMaster("local").setAppName("RddDemo")
    sc = SparkContext(conf=conf)
    readfile(sc)
    readParallelizedCollections(sc)
    countWord(mergeFile(sc))
