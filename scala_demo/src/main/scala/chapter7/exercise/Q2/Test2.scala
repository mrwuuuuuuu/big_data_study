package com {

  class T11 {
    val name = "T1"
  }
  package horstman {
    class T22 {
      val name = "T2"
    }
    package impatient {

      class T33 {
        val name = "T3"
        val x=new T4
      }

    }
  }
}

//import导入到那一层就只能引用那一层的类型
import com.horstman._
import com.horstman.impatient.T33
class test{
  val y=new T2
  val x=new T33
}