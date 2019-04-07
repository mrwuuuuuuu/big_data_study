package chapter8

/**
  * @author Vincent Wu
  * @date 2019/1/28 10:17
  */
class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  override def deposit(amount: Double): Double = super.deposit(amount - 1)

  override def withDraw(amount: Double): Double = super.withDraw(amount + 1)

}
