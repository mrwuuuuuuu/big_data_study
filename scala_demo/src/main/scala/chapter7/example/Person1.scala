package com.nubia

import com.nubia.horstmann.impatient.people.Person
import java.util.{HashMap => JavaHashMap}


/**
  * @author Vincent Wu
  * @date 2019/1/7 17:33
  */
object Person1 {
  def main(args: Array[String]): Unit = {
    println(Person.phrase)

    val map = new JavaHashMap[String, String]()
    map.put("key1", "value1")
    map.put("key2", "value2")
    map.put("key3", "value3")

    val countMap = scala.collection.mutable.Map[String, String]()
    countMap.put("key1", "value1")
    countMap.put("key2", "value2")
    countMap.put("key3", "value3")
    countMap.keySet.foreach(println)
    countMap.keySet.foreach(x=>println(x))
    countMap.values.foreach(y=>println(y))
  }

}
