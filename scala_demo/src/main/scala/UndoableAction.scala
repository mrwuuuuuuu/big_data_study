/**
  * @author Vincent Wu
  * @date 2019/1/4 14:42
  */
abstract class UndoableAction(val description: String) {
  def undo(): Unit

  def redo(): Unit
}
