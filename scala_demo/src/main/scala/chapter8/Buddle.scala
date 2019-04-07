package chapter8

import scala.collection.mutable.ArrayBuffer

/**
  * @author Vincent Wu
  * @date 2019/1/28 11:19
  */
class Buddle extends Item {
  val items = new ArrayBuffer[Item]()

  def addItem(item: Item): Unit = {
    items += item
  }

  override def price: Double = {
    var total: Double = 0
    items.foreach(total += _.price)
    total
  }

  override def description: String = {
    items.mkString(" ")
  }
}

object Buddle {

  def main(args: Array[String]): Unit = {
    val buddle=new Buddle
    buddle.addItem(new SimpleItem(12.1,"mobile phone"))
    buddle.addItem(new SimpleItem(13.1,"iphone"))

    println(buddle.description)
  }

}
