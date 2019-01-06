import scala.beans.BeanProperty
import scala.util.Random

/**
  * Created by Vincent 2019/1/6 18:12
  */
object Chapter5 {

  def main(args: Array[String]): Unit = {
    //    Q1()
    //    Q2()
    //    Q3()
    //        Q4()
    //    Q5()
    //        Q6()
    //    Q7()
    Q8()
    //    Q9()
    //    Q10()
  }

  /**
    * 改进5.1节的counter类，让它不要在Int.MaxValue时变成负数
    */
  def Q1(): Unit = {
    val counter = new Counter
    println("Int.MaxValue is:" + Int.MaxValue)
    (0 to new Random().nextInt(100)).foreach(x => {
      counter.increment()
      println(counter.current())
    })
    println(counter.current())
  }

  /**
    * 编写一个BankAccount类，加入deposit和withdraw方法，以及一个只读的balance属性 。
    */
  def Q2(): Unit = {
    val account = new BankAccount
    account.deposit(111)
    account.withdraw(22)
    println(account.getBalance)
  }

  /**
    * 编写一个 Time类，加人只读属性hours和minutes，以及一个检查某一时刻是否早于另一时刻的方法before (other: Time) : Boolean。
    * Time对象应该以new Time (hrs,min)方式构建，其中 hrs小时数以军用时间格式呈现(介于0和23之间）。
    */
  def Q3(): Unit = {
    val time1 = new Time(8, 30)
    val time2 = new Time(7, 34)
    val time3 = new Time(8, 30)
    val time4 = new Time(9, 24)
    println(time1.before(time2))
    println(time1.before(time3))
    println(time1.before(time4))
  }

  /**
    * 重新实现前一个练习中的 Time类，将内部呈现改成自午夜起的分钟数（介于0到24×60-1之间）。
    * 不要改变公有接口。也就是说，客户端代码不应因你的修改而受到影响 。
    */
  def Q4(): Unit = {
    val time1 = new NewTime(8, 30)
    val time2 = new NewTime(7, 34)
    val time3 = new NewTime(8, 30)
    val time4 = new NewTime(9, 24)
    println(time1.before(time2))
    println(time1.before(time3))
    println(time1.before(time4))
  }

  /**
    * 创建一个 Student类，加入可读写的 JavaBeans属性 name（类型为 String）和id（类型为Long）。
    * 有哪些方法被生成？（用javap查看）。你可以在Scala中调用JavaBeans版的getter和setter方法吗？
    */
  def Q5(): Unit = {
    val stu1 = new Student()
    stu1.name = "Vincent"
    println(stu1.id + " :" + stu1.name)
    val stu2 = new Student()
    println(stu2.id + " :" + stu2.name)
  }

  /**
    * 在 5.1 节的 Person类中提供一个主构造器，将负年龄转换为 0 。
    */
  def Q6(): Unit = {
    val p1 = new Person("Vincent", 21)
    println(p1.getName, p1.getAge)
    val p2 = new Person("Vincent", -1)
    println(p2.getName, p2.getAge)
  }

  /**
    * 编写一个 Person类，其主构造器接受一个字符串，该字符串包含名字 、空格和姓，比如new Person (” Fred Smith ”） 。
    * 提供只读属性firstName和lastName 。 主构造器参数应该是var、val还是普通参数呢？为什么？
    */
  def Q7(): Unit = {
    val p1 = new Person2("Vincent Wu")
    println(p1.fullName)
  }

  /**
    * 创建一个 Car类，以只读属性对应制造商、型号名称、型号年份以及一个可读写的属性用于车牌 。
    * 提供四组构造器 。 每一个构造器都要求制造商和型号名称为必填 。
    * 型号年份以及车牌为可选，如果未填，则型号年份设置为－ 1 ，车牌
    * 设置为空字符串 。 你会选择哪一个作为你的主构造器？为什么？
    */
  def Q8(): Unit = {
    val car = new Car("Bens", "S500")
    println(car)
    val car1 = new Car("Bens", "S500", 2018)
    println(car1)
    val car2 = new Car("Bens", "S500", "AB35367")
    println(car2)
    val car3 = new Car("Bens", "S500", 2018, "AC45678")
    println(car3)

    println(car3.getMF())
    println(car3.getMN())
    car3.setCarNo("ABC1234")
    println(car3)
  }

  /**
    * 在 Java 、C＃或 C++（你自己选）中重做前一个练习。相比之下 Scala精简了多少？
    */
  def Q9() {}

  /**
    * 考虑如下类 ：
    * class Employee (val name: String, var salary : Double) {
    * def this () { this (” John Q. Public", 0.0 ) }
    * 练习
    * 重写该类，使用显式的宇段定义和一个默认主构造器 。 你更倾向于使用哪一种
    * 形式？为什么？
    */
  def Q10() {}
}

class Counter {
  private var value = Int.MaxValue - 10
  private var longValue: Long = 0

  def increment(): Unit = {
    if (value == Int.MaxValue) {
      longValue += 1
    }
    else {
      value += 1
      longValue = value
    }
  }

  def current() = {
    if (value == Int.MaxValue) longValue else value.toLong
  }
}

class BankAccount(private var balance: Double = 1.0) {

  def deposit(amount: Double): Unit = {
    balance += amount
  }

  def withdraw(amount: Double): Unit = {
    balance -= amount
  }

  def getBalance = balance
}

class Time(private val hours: Int, private val minutes: Int) {

  def getHours = hours

  def getMinutes = minutes

  def before(other: Time): Boolean = {
    this.hours < other.hours || (this.hours == other.hours && this.minutes < other.minutes)
  }
}

class NewTime(private val hours: Int, private val minutes: Int) {

  def getHours = hours

  def getMinutes = minutes

  def before(other: NewTime): Boolean = {
    (this.hours * 60 + this.minutes) < (other.hours * 60 + other.minutes)
  }
}

class Student() {
  @BeanProperty var name: String = _
  @BeanProperty var id: Long = _
}

class Person(val name: String, private var age: Int) {
  age = if (age < 0) 0 else age

  def getName = name

  def getAge = age
}

class Person2(val fullName: String) {
  val firstName = fullName.split(" ")(0)
  val lastName = fullName.split(" ")(1)
}

class Car(private val manufacturer: String, private val modelName: String, private var year: Int = -1, private var carNo: String = "x") {

  def this(mf: String, mn: String, year: Int) {
    this(mf, mn, year, "")
  }

  def this(mf: String, mn: String, carNo: String) {
    this(mf, mn, -1, carNo)
  }

  def getMF() = manufacturer

  def getMN() = modelName

  def setCarNo(no: String): Unit = {
    this.carNo = no
  }

  override def toString: String = "[" + manufacturer + "," + modelName + "," + year + "," + carNo + "]"
}