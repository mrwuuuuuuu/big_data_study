package chapter6.Q6

/**
  * @author Vincent Wu
  * @date 2019/1/7 10:58
  */
object CardType extends Enumeration {
  type CardType = Value
  val Heart = Value("♥")
  val Spade = Value("♠")
  val Diamond = Value("♦")
  val Club = Value("♣")

  def check(cardType1: CardType, cardType2: CardType): Boolean = {
    cardType1.id == cardType2.id
  }
}
