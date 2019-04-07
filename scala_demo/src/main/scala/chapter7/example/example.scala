package chapter7.example

/**
  * @author Vincent Wu
  * @date 2019/1/7 15:01
  */
object example {


  def main(args: Array[String]): Unit = {
    val x = new com.horstmann.impatient.Employee
    val y = new com.horstmann.impatient.Employee1
    println(x.getPhrase)
    println(y.getPhrase)

    val m = new A.B.C.Employee
    val n = new D.E.F.Employee

    println(m.getPhrase)
    println(n.getPhrase)

    val e = new A.B.C.D.E.Employee("Vincent", 10000)


    import A.B.C.D.E._
    val e1 = Employee("Vincent", 20000)
    Employee.printInfo(e)
    Employee.printInfo(e1)

    println(defaultName)

    printStr(defaultName)


  }
}
