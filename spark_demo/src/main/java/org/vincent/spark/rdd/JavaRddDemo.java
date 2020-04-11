package org.vincent.spark.rdd;

import com.google.common.collect.Lists;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * @author Vincent Wu
 * @datetime 2020/4/6 11:13
 */
public class JavaRddDemo {
    public static void main(String[] args) {
        JavaSparkContext context = new JavaSparkContext(new SparkConf().setMaster("local[*]").setAppName("JavaRdd"));
        JavaRDD javaRDD = context.parallelize(Lists.newArrayList("1,2,3,4,5,6"));
        javaRDD.repartition(2).foreach(x->System.out.print(x));
    }
}
