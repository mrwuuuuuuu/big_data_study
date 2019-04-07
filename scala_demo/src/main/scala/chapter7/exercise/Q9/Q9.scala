package chapter7.exercise.Q9

import scala.io.StdIn

/**
  * @author Vincent Wu
  * @date 2019/1/21 21:28
  */
object Q9 {
  import java.lang.System
  def main(args: Array[String]): Unit = {
    val userName=System.getProperty("user.name")
    val passwd=StdIn.readLine()
    if(passwd.equals("secret")) System.out.print("hello,"+userName) else  System.err.print("error passwd")
  }

}
