package chapter8

/**
  * @author Vincent Wu
  * @date 2019/1/28 11:02
  */
class Rectangle(val length: Double, val hight: Double) extends Shape {

  override def perimeter: Double = (length + hight) * 2

  override def area: Double = length * hight
}
