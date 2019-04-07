import java.io.File
import java.util.{Calendar, Scanner}

import scala.collection.JavaConverters._

/**
  * @author Vincent Wu
  * @date 2019/1/3 11:09
  */
object Chapter4 {
  def main(args: Array[String]): Unit = {
    //    Q1()
    //    Q2()
    //    Q3()
    //    Q4()
    //    Q5()
    //    Q6()
    //    Q7()
    //        Q8()
    Q9()
    //    Q10()
  }

  def Q1(): Unit = {
    val map = Map("Java" -> 100.0, "Python" -> 90.8, "Scala" -> 89.3)
    val result = for ((k, v) <- map) yield (k, v * 0.9)
    println(result)
  }

  def Q2(): Unit = {
    val in = new Scanner(new File("d:\\data\\test.txt"))
    val countMap = scala.collection.mutable.Map[String, Int]()
    while (in.hasNext()) {
      val word = in.next()
      countMap(word) = countMap.getOrElse(word, 0) + 1
    }
    println(countMap)
  }

  def Q3(): Unit = {
    val in = new Scanner(new File("d:\\data\\test.txt"))
    var countMap = Map[String, Int]()
    while (in.hasNext()) {
      val word = in.next()
      countMap += (word -> (countMap.getOrElse(word, 0) + 1))
    }
    println(countMap)
  }

  def Q4(): Unit = {
    val in = new Scanner(new File("d:\\data\\test.txt"))
    var countMap = scala.collection.immutable.SortedMap[String, Int]()
    while (in.hasNext()) {
      val word = in.next()
      countMap += (word -> (countMap.getOrElse(word, 0) + 1))
    }
    println(countMap)
  }

  def Q5(): Unit = {
    val in = new Scanner(new File("d:\\data\\test.txt"))
    var countMap: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int].asScala
    while (in.hasNext()) {
      val word = in.next()
      countMap += (word -> (countMap.getOrElse(word, 0) + 1))
    }
    println(countMap)
  }

  def Q6(): Unit = {
    val weekMap = scala.collection.mutable.LinkedHashMap[String, Int](
      "MONDAY" -> Calendar.MONDAY,
      "TUESDAY" -> Calendar.TUESDAY,
      "WEDNESDAY" -> Calendar.WEDNESDAY,
      "TUESDAY" -> Calendar.TUESDAY,
      "FRIDAY" -> Calendar.FRIDAY,
      "SATURDAY" -> Calendar.SATURDAY,
      "SUNDAY" -> Calendar.SUNDAY
    )
    println(weekMap)
  }

  def Q7(): Unit = {
    val props: scala.collection.mutable.Map[String, String] = System.getProperties.asScala
    val keyLength = for (x <- props.keySet) yield x.length
    val maxLength = keyLength.max
    for ((k, v) <- props) {
      if (k.length < maxLength) print(k + " " * (maxLength - k.length) + " |")
      else print(k + " |")
      println(v)
    }
  }

  def Q8(): Unit = {
    val values = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(minmax(values))
  }

  def minmax(values: Array[Int]): (Int, Int) = {
    val tupe: (Int, Int) = (values.max, values.min)
    tupe
  }

  def Q9(): Unit = {
    val values = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val result = lteqgt(values, 5)
    println(result)
  }

  def lteqgt(values: Array[Int], v: Int): (Int, Int, Int) = {
    var first, second, third = 0
    for (x <- values) {
      if (x < v) first += 1
      else if (x == v) second += 1
      else third += 1
    }
    println((values.count(_ < v), values.count(_ == v), values.count(_ > v)))
    (first, second, third)
  }

  def Q10(): Unit = {
    val x = "Hello".zip("World")
    println(x)
  }

}
