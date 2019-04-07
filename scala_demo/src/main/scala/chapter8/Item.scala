package chapter8

/**
  * @author Vincent Wu
  * @date 2019/1/28 11:13
  */
abstract class Item {
  def price: Double

  def description: String

  override def toString: String = "description:" + description + " price:" + price
}
