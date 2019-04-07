package chapter7.exercise

/**
  * @author Vincent Wu
  * @date 2019/1/21 20:37
  */
package object RandomUtils {
  var seed: Int = _
  val a: BigInt = 1664525
  val b: BigInt = 1013904223
  val n: Int = 32

  def nextInt(): Int = {
    val tmp = (seed * a + b) % BigInt(2).pow(n)
    seed = tmp.toInt
    seed
  }

  def nextDouble(): Double = {
    val tmp = (seed * a + b) % BigInt(2).pow(n)
    seed = tmp.toInt
    tmp.toDouble
  }
}
