/**
  * @author Vincent Wu
  * @date 2019/1/4 14:43
  */
object DoNothingAction extends UndoableAction("Do nothing") {
  override def undo(): Unit = {}

  override def redo(): Unit = {}
}
