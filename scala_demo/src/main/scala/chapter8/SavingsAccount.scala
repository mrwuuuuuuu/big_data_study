package chapter8

/**
  * @author Vincent Wu
  * @date 2019/1/28 10:33
  */
class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private var num: Int = _

  def earnMonthlyInterest = {
    num = 3
    super.deposit(1) //存入利息
  }

  override def deposit(amount: Double): Double = {
    num -= 1
    if (num <= 0)
      super.deposit(amount - 1)
    else
      super.deposit(amount)
  }

  override def withDraw(amount: Double): Double = {
    num -= 1
    if (num <= 0)
      super.withDraw(amount + 1)
    else
      super.withDraw(amount)
  }

}
