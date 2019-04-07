package chapter10

/**
  * @author Vincent Wu
  * @date 2019/1/29 20:04
  */
trait ShortLogger extends ConsoleLogger {
  override def log(msg: String): Unit = super.log(s"${java.time.Instant.EPOCH} $msg")
}
