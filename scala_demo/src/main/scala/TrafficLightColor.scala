/**
  * @author Vincent Wu
  * @date 2019/1/4 15:10
  */
object TrafficLightColor extends Enumeration {
  type TrafficLightColor = Value
  val Red, Yellow, Green = Value

  def main(args: Array[String]): Unit = {
    println(Red.id+""+Yellow)
  }

}
