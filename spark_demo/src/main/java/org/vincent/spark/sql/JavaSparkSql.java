package org.vincent.spark.sql;

import com.google.common.collect.Lists;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.api.java.UDF8;
import org.apache.spark.sql.types.DataTypes;

import java.util.List;

/**
 * @author Wu Xiaobing
 * @date 2020/4/10 9:35
 */
public class JavaSparkSql {

    public List<Integer> compute(int... args) {
        List<Integer> even = Lists.newArrayList();
        for (Integer arg : args) {
            if (arg % 2 == 0) {
                even.add(arg);
            }
        }
        return even;
    }

    public static void main(String[] args) throws AnalysisException {
        SparkSession spark = SparkSession.builder().master("local[*]").appName("SparkSql").getOrCreate();
        Dataset<Row> df = spark.read().option("header", "true").option("inferSchema", true).csv("src/main/resources/data.csv");

        df.show(1);

        df.createTempView("temp");
        spark.udf().register("compute", (UDF8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, List<Integer>>) (o, o2, o3, o4, o5, o6, o7, o8) -> new JavaSparkSql().compute(o, o2, o3, o4, o5, o6, o7, o8), DataTypes.createArrayType(DataTypes.IntegerType));
        spark.sql("select id,compute(height1,height2,height3,height4,width1,width2,width3,width4) as even from temp limit 10").createTempView("temp1");
        spark.sql("select id,even[1] as col1 from temp1").show(5);
    }
}
