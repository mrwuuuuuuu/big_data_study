package chapter6.Q2

/**
  * @author Vincent Wu
  * @date 2019/1/7 10:14
  */
abstract class UnitConversion {
  def inchesToCentimeters(): Unit

  def gallonsToLiters(): Unit

  def milesToKilometers(): Unit
}

object Conversion extends UnitConversion {
  override def inchesToCentimeters(): Unit = ???

  override def gallonsToLiters(): Unit = ???

  override def milesToKilometers(): Unit = ???
}
