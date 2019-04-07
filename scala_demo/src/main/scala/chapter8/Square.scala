package chapter8

import java.awt.{Point, Rectangle}

/**
  * @author Vincent Wu
  * @date 2019/1/28 15:52
  */
class Square(point: java.awt.Point, width: Double) extends Rectangle(point.x, point.y) {
  def this(width: Double) {
    this(new java.awt.Point(0, 0), width)
  }

  def this() {
    this(new java.awt.Point(0, 0), 0)
  }

}
