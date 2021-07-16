package dataflow;

import com.google.common.base.Splitter;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.ObjectWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.List;

/**
 * @author Vincent Wu
 * @datetime 2021/7/16 14:43
 */
public class DataflowMR {
    static class Map extends Mapper<LongWritable, Text, Text, ObjectWritable> {
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            List<String> mobileDataInfos = Splitter.on("\t").trimResults().splitToList(value.toString());
            String mobileNo = mobileDataInfos.get(1);
            Long upFlow = Long.valueOf(mobileDataInfos.get(7));
            Long downFlow = Long.valueOf(mobileDataInfos.get(8));
            MobileDataFlow dataFlow = new MobileDataFlow(upFlow, downFlow);
            context.write(new Text(mobileNo), new ObjectWritable(dataFlow));
        }

    }

    static class Reduce extends Reducer<Text, ObjectWritable, Text, Text> {
        @Override
        protected void reduce(Text key, Iterable<ObjectWritable> values, Context context) throws IOException, InterruptedException {
            Long totalUpFlow = 0L;
            Long totalDownFlow = 0L;
            for (ObjectWritable value : values) {
                MobileDataFlow mobileDataFow = (MobileDataFlow) value.get();
                totalUpFlow += mobileDataFow.getUpFlow();
                totalDownFlow += mobileDataFow.getDownFlow();
            }
            MobileDataFlow totalDataFlow = new MobileDataFlow(totalUpFlow, totalDownFlow);
            context.write(key, new Text(totalDataFlow.toString()));
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        String hdfsInPath = "/user/presto/jike_bigdata_mr/input";
        String hdfsOutPath = "/user/presto/jike_bigdata_mr/output";
        Job job = new Job();
        job.setJarByClass(DataflowMR.class);
        job.setJobName("data_flow_mr_vincent");
        FileInputFormat.addInputPath(job, new Path(hdfsInPath));
        FileOutputFormat.setOutputPath(job, new Path(hdfsOutPath));
        job.setMapperClass(DataflowMR.Map.class);
        job.setReducerClass(DataflowMR.Reduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(ObjectWritable.class);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
