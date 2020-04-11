package org.vincent.spark.example.sql

import org.apache.spark.sql.SparkSession

import scala.collection.mutable.ListBuffer

/**
 *
 *
 * @author Wu Xiaobing
 * @date 2020/4/10 9:36
 */
object ScalaSparkSql {

  def compute(args: Integer*): ListBuffer[Integer] = {

    val evenList = ListBuffer[Integer]()
    args.foreach(x => if (x % 2 == 0) {
      evenList.append(x)
    })
    evenList
  }


  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Spark sql").master("local[*]").getOrCreate()
    val df = spark.read.format("csv").option("header", "true").option("inferSchema", true).load("src/main/resources/data.csv")
    df.show(1)
    df.createOrReplaceTempView("temp")
    spark.udf.register("compute", compute(_: Integer, _: Integer, _: Integer, _: Integer, _: Integer, _: Integer, _: Integer, _: Integer))
    spark.sql("select id,compute(height1,height2,height3,height4,width1,width2,width3,width4) as even from temp").createOrReplaceTempView("temp2")
    spark.sql("select id ,even[1] as col1 from temp2").show(5)
  }

}
