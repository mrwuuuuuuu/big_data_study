package chapter7.exercise.Q3

/**
  * @author Vincent Wu
  * @date 2019/1/21 20:47
  */
object Test extends App{
  import chapter7.exercise.RandomUtils
  RandomUtils.seed=10
  println("seed:"+RandomUtils.seed)
  println(RandomUtils.nextInt())
  println("seed:"+RandomUtils.seed)
  println(RandomUtils.nextDouble())
  println("seed:"+RandomUtils.seed)

}
