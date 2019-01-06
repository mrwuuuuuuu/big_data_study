import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Vincent 2019/1/4 0:14
  */
object ScalaWordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local[*]")
    conf.setAppName("MyWordCount")
    val sc = new SparkContext(conf)

    val rdd1 = sc.textFile(args(0))
    val rdd2 = rdd1.flatMap(line => line.split(" "))
    val rdd3 = rdd2.map(word => (word, 1))
    val rdd4 = rdd3.reduceByKey((a, b) => a + b)
    val values = rdd4.collect()
    println(values.toBuffer)
  }

}
