package org.vincent.spark.sql

import org.apache.spark.sql.expressions.Aggregator
import org.apache.spark.sql.{Encoder, Encoders, SparkSession}

/**
 * @author Vincent Wu
 * @datetime 2020/4/12 21:00
 */
case class Employee(name: String, salary: Long)

case class Average(var sum: Long, var count: Long)

object MyAverage2 extends Aggregator[Employee, Average, Double] {
  override def zero: Average = Average(0, 0)

  override def reduce(b: Average, a: Employee): Average = {
    b.sum += a.salary
    b.count += 1
    b
  }

  override def merge(b1: Average, b2: Average): Average = {
    b1.sum += b2.sum
    b1.count += b2.count
    b1
  }

  override def finish(reduction: Average): Double = reduction.sum.toDouble / reduction.count

  override def bufferEncoder: Encoder[Average] = Encoders.product

  override def outputEncoder: Encoder[Double] = Encoders.scalaDouble

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("Spark sql").master("local[*]").getOrCreate()
    import spark.implicits._
    val ds = spark.read.json("src/main/resources/employees.json").as[Employee]
    val averageSalary = MyAverage2.toColumn.name("average_salary")
    ds.select(averageSalary).show()
  }
}
