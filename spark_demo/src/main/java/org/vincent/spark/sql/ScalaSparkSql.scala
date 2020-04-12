package org.vincent.spark.example.sql

import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}

import scala.collection.mutable.ListBuffer

/**
 *
 *
 * @author Wu Xiaobing
 * @date 2020/4/10 9:36
 */
object ScalaSparkSql {

  case class Person(name: String, age: Integer)

  /**
   * udf function
   *
   * @param args 输入列参数
   * @return
   */
  def compute(args: Integer*): ListBuffer[Integer] = {
    val evenList = ListBuffer[Integer]()
    args.foreach(x => if (x % 2 == 0) {
      evenList.append(x)
    })
    evenList
  }

  /**
   * 注册udf函数，并使用sql
   *
   * @param spark
   * @param df
   */
  def udfDemo(spark: SparkSession, df: DataFrame) = {
    df.createOrReplaceTempView("temp")
    spark.udf.register("compute", compute(_: Integer, _: Integer, _: Integer, _: Integer, _: Integer, _: Integer, _: Integer, _: Integer))
    spark.sql("select id,compute(height1,height2,height3,height4,width1,width2,width3,width4) as even from temp").createOrReplaceTempView("temp2")
    spark.sql("select id ,even[1] as col1 from temp2").show(5)
  }

  /**
   * 通过txt来创建Dataframe,并设置schema
   *
   * @param spark
   */
  def createDataFrameFromTxt(spark: SparkSession) = {
    val fields = List(StructField("name", StringType, true), StructField("age", IntegerType, true))

    val schema = StructType(fields)

    val peopleRdd = spark.sparkContext
      .textFile("src/main/resources/people.txt")
      .map(_.split(","))
      .map(item => Row(item(0), item(1).trim().toInt))

    val peopleDF = spark.createDataFrame(peopleRdd, schema)

    peopleDF.select("name", "age").show()
  }

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Spark sql").master("local[*]").getOrCreate()
    val df = spark.read.format("csv").option("header", "true").option("inferSchema", true).load("src/main/resources/data.csv")
    df.show(1)
    //    udfDemo(spark, df)
    //    createDataFrameFromTxt1(spark)
    //    createDataFrameFromTxt(spark)
  }

}
