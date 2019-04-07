package org.vincent.study.bigdata.kafka;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerSimple {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        InputStream inStream = KafkaConsumerSimple.class.getClassLoader().getResourceAsStream("consumer.properties");
        properties.load(inStream);
        Consumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList("myTest"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            if (records.count() > 0) {
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(record.value());
                }
            }
        }
    }
}