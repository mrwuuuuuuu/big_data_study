import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
  * @author Vincent Wu
  * @date 2018/12/29 10:03
  */
object Charpter2 {
  def main(args: Array[String]): Unit = {
    //    Q1()
    //    Q2()
    //    Q3()
    //    Q4()
    //    Q5()
    //    Q6()
    //    Q7()
    //    Q8()
    //    Q9()
    //    Q10()
  }

  def Q1(): Unit = {
    print("Please input a num:")
    val num = readInt()
    val result = getSignNum(num)
    println(result)
  }

  def Q2(): Unit = {
    println("块语句是一个包含于{}的语句序列,其值为:(),的类型为:Unit")
    val value = {}
    println(s"the value of '{}' is: $value")
  }

  def Q3() = {}

  def Q4() = {
    //    cycle1()
    cycle2()
  }

  def Q5() = {
    countDown(18)
  }

  def Q6() = {
    val multiValue1 = multiChar1("Hello")
    println(multiValue1)
  }

  def Q7() = {
    val multiValue2 = multiChar2("Hello")
    println(multiValue2)
  }

  def Q8() = {
    val multiValue2 = multiChar2("Hello")
    println(multiValue2)
  }

  def Q9() = {
    val result = multiCharRecur("Hello")
    println(result)
  }

  def Q10() = {}


  def getSignNum(num: Int): Int = {
    if (num > 0) 1 else if (num < 0) -1 else 0
  }

  def cycle1() = {
    for (i <- 0 to 10; value = 10 - i)
      println(value)
  }

  def cycle2() = {
    var x = 10
    while (x >= 0) {
      println(x)
      x -= 1
    }
  }

  def countDown(n: Int) {
    for (i <- 0 to n; value = n - i)
      println(value)
  }

  def multiChar1(str: String) = {
    var result: BigInt = 1
    for (c <- str)
      result *= c.toInt
    result
  }

  def multiChar2(str: String) = {
    var result: BigInt = 1
    str.foreach(f => result *= f.toInt)
    result
  }

  def multiCharRecur(str: String): BigInt = {
    val firstCharInt = str.charAt(0).toInt
    if (str.length == 1) firstCharInt
    else firstCharInt * multiCharRecur(str.tail)
  }


  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
    def date(args: Any*): Unit = {
    }
  }
}
