package chapter6.Q5

/**
  * @author Vincent Wu
  * @date 2019/1/7 10:51
  */
object ReversePhrase extends App {

  reverse("scala reverse hello world")

  def reverse(phrase: String) = {
    val array = phrase.split(" ")

    for (i <- (0 to array.length - 1).reverse) print(array(i) + " ")
  }

}
