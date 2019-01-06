import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Created by Vincent 2019/1/4 0:52
 */
public class JavaWordCount {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.setMaster("local");
        conf.setAppName("JavaWordCount");

        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> rdd1 = sc.textFile(args[0]);
        JavaRDD<String> rdd2 = rdd1.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
        JavaPairRDD<String, Integer> rdd3 = rdd2.mapToPair(word -> new Tuple2<>(word, 1));
        JavaPairRDD<String, Integer> rdd4 = rdd3.reduceByKey((a, b) -> a + b);

        System.out.println(rdd4.collectAsMap());
    }
}
