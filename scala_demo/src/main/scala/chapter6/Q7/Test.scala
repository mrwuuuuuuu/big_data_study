package chapter6.Q7

import chapter6.Q6.CardType

/**
  * @author Vincent Wu
  * @date 2019/1/7 11:22
  */
object Test {

  def main(args: Array[String]): Unit = {
    val x= CardType.Heart
    print(CardType.check(x,CardType.Heart))

  }

}
