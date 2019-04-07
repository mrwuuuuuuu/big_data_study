package chapter10

/**
  * @author Vincent Wu
  * @date 2019/1/29 16:59
  */
abstract class SavingAccount(balance: Double) extends Logger {
  def withDraw(amount: Double): Unit = {
    if (balance > amount) log("insufficient funds") else log("OK")
  }
}
