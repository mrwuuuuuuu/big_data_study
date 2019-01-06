import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object Chapter3 {
  def main(args: Array[String]): Unit = {
    //    Q1(12)
        Q2(Array(1,2,3,4,5,6))
        Q3(Array(1,2,3,4,5,6))
    //    Q4(Array(1,2,3,4))
    //    Q5(Array(1, -2, -3, 4, 5, -6, 7, -8, 9))
    //    Q6()
  }

  def Q1(n: Int) = {
    val a = new Array[Int](n)
    for (i <- a.indices) {
      a(i) = Random.nextInt(n)
    }
    println("array is:" + a.mkString(","))
  }

  def Q2(a: Array[Int]) = {
    println("original array is:" + a.mkString(","))
    for (i <- Range.inclusive(0, if (a.size % 2 == 0) a.length - 1 else a.length - 2, 2)) {
      val temp = a(i)
      a(i) = a(i + 1)
      a(i + 1) = temp
    }
    println("transferred array is:" + a.mkString(","))
  }

  def Q3(a: Array[Int]) = {
    println("original array is:" + a.mkString(","))
    val b = for (i <- a.indices) yield {
      if (i % 2 == 0 && i < a.length - 1) a(i + 1)
      else if (i % 2 != 0) a(i - 1)
      else a(i)
    }
    println("transferred array is:" + b.mkString(","))
  }

  def Q4(a: Array[Int]) = {
    println("original array is:" + a.mkString(","))
    var b = for (x <- a if x > 0) yield x
    val c = for (x <- a if x <= 0) yield x
    b ++= c
    println("transferred array is:" + b.mkString(","))
  }


  def Q5(a: Array[Double]) = {
    println("avg is:" + (a.sum * 1.0 / a.length))
  }

  def Q6() = {
    reverse1(Array(1, -2, -3, 4, 5, -6, 7, -8, 9))
    reverse2(ArrayBuffer(1, -2, -3, 4, 5, -6, 7, -8, 9))
  }

  def reverse1(a: Array[Int]): Unit = {
    println("original array is:" + a.mkString(","))
    val b = a.reverse
    println("transferred array is:" + b.mkString(","))
  }

  def reverse2(a: ArrayBuffer[Int]): Unit = {
    println("original array is:" + a.mkString(","))
    val b = a.reverse
    println("transferred array is:" + b.mkString(","))
  }

}
