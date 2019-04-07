package chapter8

/**
  * @author Vincent Wu
  * @date 2019/1/28 10:54
  */
class Circle(val radius: Double) extends Shape {
  override def perimeter: Double = 2 * Math.PI * radius

  override def area: Double = Math.PI * Math.pow(radius, 2)
}
