

/**
  * @author Vincent Wu
  * @date 2018/12/28 18:36
  */
object HelloWorld {
  def main(args: Array[String]): Unit = {
    val actions = Map("open" -> DoNothingAction.redo(), "save" -> DoNothingAction.undo())
  }
}
