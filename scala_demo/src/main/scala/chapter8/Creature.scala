package chapter8

/**
  * @author Vincent Wu
  * @date 2019/1/28 16:26
  */
class Creature {
  def range: Int = 10

  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override val range: Int = super.range
}
