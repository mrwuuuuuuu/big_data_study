from pyspark.sql import SparkSession
from pyspark.sql.types import ArrayType, IntegerType


def compute(*args):
    even = []
    for arg in args:
        if arg % 2 == 0:
            even.append(arg)
    return even


if __name__ == '__main__':
    spark = SparkSession.builder.appName("Spark sql").master("local[*]").getOrCreate()
    df = spark.read.format("csv").option("header", "true").option("inferSchema", True).load("../../../../file/data.csv")
    df.show(1)
    df.createOrReplaceTempView("temp")
    spark.udf.register("compute", compute, ArrayType(IntegerType()))
    df1 = spark.sql(
        "select id, compute(height1, height2, height3, height4, width1, width2, width3, width4) as even from temp")
    df1.show()
    df1.createOrReplaceTempView("temp2")
    spark.sql("select id ,even[1] as col1 from temp2").show(5)
