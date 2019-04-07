package chapter8

/**
  * @author Vincent Wu
  * @date 2019/1/28 10:14
  */
class BankAccount(initialBalance: Double) {
  private var balance = initialBalance

  def currentBalance = balance

  def deposit(amount: Double) = {
    balance += amount
    balance
  }

  def withDraw(amount: Double) = {
    balance -= amount
    balance
  }

}
