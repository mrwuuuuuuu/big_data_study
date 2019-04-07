package chapter10

/**
  * @author Vincent Wu
  * @date 2019/1/29 16:57
  */
trait ConsoleLogger extends Logger {
  def log(msg: String) {
    println(msg)
  }
}
