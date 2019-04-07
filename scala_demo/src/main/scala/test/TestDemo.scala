package test

/**
  * @author Vincent Wu
  * @date 2019/3/16 15:14
  */
object TestDemo {
  def twoNums(nums: Array[Int], target: Int): Array[Int] = {
    val map = new scala.collection.mutable.HashMap[Int, Int]()
    val result = new Array[Int](2)
    for (i <- 0 to (nums.length - 1)) {
      val value = target-nums(i)
      if (map.contains(value)) {
        result(0) = i
        result(1) = map.get(value).get
      }
      map.put(nums(i), i)
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(2, 7, 11, 15)
    println(twoNums(arr, 9))
  }
}
