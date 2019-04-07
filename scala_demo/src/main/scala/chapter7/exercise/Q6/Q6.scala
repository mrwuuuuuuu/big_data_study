package chapter7.exercise.Q6

/**
  * @author Vincent Wu
  * @date 2019/1/21 20:55
  */
object Q6 {

  import java.util.{HashMap => JavaHashMap}
  import scala.collection.mutable.{HashMap => ScalaHashMap}

  def main(args: Array[String]): Unit = {
    val map1 = new JavaHashMap[Int, String]()
    map1.put(1, "val1")
    map1.put(2, "val2")
    map1.put(3, "val3")

    var map2 = new ScalaHashMap[Int, String]()

    for (k <- map1.keySet().toArray()) {
      map2 += (Integer.valueOf(k.toString).toInt -> map1.get(k).toString)
    }

    println(map2)
  }

}
