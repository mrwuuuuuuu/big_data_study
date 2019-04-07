package chapter10

/**
  * @author Vincent Wu
  * @date 2019/1/29 16:58
  */
trait FileLogger extends Logger {
  override def log(msg: String): Unit = println("FileLogger log------->" + msg)
}
