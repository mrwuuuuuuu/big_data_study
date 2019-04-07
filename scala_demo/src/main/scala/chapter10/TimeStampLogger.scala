package chapter10

/**
  * @author Vincent Wu
  * @date 2019/1/29 20:02
  */
trait TimeStampLogger extends Logger {
  abstract override def log(msg: String): Unit = super.log(s"${java.time.Instant.now()} $msg")
}
