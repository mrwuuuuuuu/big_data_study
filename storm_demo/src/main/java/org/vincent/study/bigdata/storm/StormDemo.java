package org.vincent.study.bigdata.storm;

import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.testing.TestConfBolt;
import org.apache.storm.testing.TestWordCounter;
import org.apache.storm.testing.TestWordSpout;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

/**
 * @author Vincent Wu
 * @date 2019/3/11 20:06
 */
public class StormDemo {
    public static void main(String[] args) throws InvalidTopologyException, AuthorizationException, AlreadyAliveException {

        TopologyBuilder builder = new TopologyBuilder();

        //1.设置一个spout
        builder.setSpout("spout", new TestWordSpout(), 5);

        //2.设置一个bolt，8为并发读，从spout获取数据
        //shuffleGrouping--随机选择
        builder.setBolt("split", new TestConfBolt(), 8).shuffleGrouping("spout");

        //3.设置一个bolt，12为并发度，从split获取数据，
        //fieldsGrouping--按照fields进行hash
        builder.setBolt("count", new TestWordCounter(), 12).fieldsGrouping("split", new Fields("word"));

        Config conf = new Config();
        conf.setDebug(true);

        if (args != null && args.length > 0) {
            conf.setNumWorkers(3);
            StormSubmitter.submitTopologyWithProgressBar(args[0], conf, builder.createTopology());
        }
    }
}
