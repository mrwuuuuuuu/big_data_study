package chapter6.Q4

/**
  * @author Vincent Wu
  * @date 2019/1/7 10:36
  */
class Point {
  private var x: Int = _
  private var y: Int = _

  def this(x: Int, y: Int) {
    this()
    this.x = x
    this.y = y
  }

  override def toString: String = "[" + x + "," + y + "]"


}

object Point {
  def apply: Point = new Point()

  def apply(x: Int, y: Int): Point = {
    val point = new Point(x, y)
    point
  }
}

object test {
  def main(args: Array[String]): Unit = {
    val point = Point(1, 2)
    println(point)
  }
}
