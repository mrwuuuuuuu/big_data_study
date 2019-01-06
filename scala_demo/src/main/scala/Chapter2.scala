import java.time.LocalDate

/**
  * @author Vincent Wu
  * @date 2018/12/29 10:03
  */
object Chapter2 {
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
        Q10()
//    Q11()
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

  def Q3() = {
    var x = {}
    var y = 1
    x = y = 7
  }

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

  def Q10() = {
    println(getValue(2.5,6))
  }

  def getValue(x: Double, n: Int): Double = {
    if (n > 0 && n % 2 == 0) getValue(x, n / 2) * getValue(x, n / 2)
    else if (n > 0 && n % 2 != 0) x * getValue(x, n - 1)
    else if (n == 0) 1
    else 1 / getValue(x, -n)
  }


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
    str.foreach(result *= _.toInt)
    result
  }

  def multiCharRecur(str: String): BigInt = {
    val firstCharInt = str.charAt(0).toInt
    if (str.length == 1) firstCharInt
    else firstCharInt * multiCharRecur(str.tail)
  }


  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
    def date(args: Any*): LocalDate = {
      if (args.length != 3) throw new IllegalArgumentException("must input 3 args")

      args.foreach(x => if (!x.isInstanceOf[Int]) {
        throw new IllegalArgumentException("must input integer")
      })

      val x = sc.parts
      if (x(1) != "-" || x(2) != "-") throw new IllegalArgumentException("args must be split by '-'")

      val year = args(0).toString.toInt
      val month = args(1).toString.toInt
      val day = args(2).toString.toInt

      LocalDate.of(year, month, day)
    }
  }


  def Q11() = {
    val year = 2018
    val month = 12
    val day = 29

    println(date"$year-$month-$day")
  }

}
