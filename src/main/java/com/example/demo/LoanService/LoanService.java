package com.example.demo.LoanService;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class LoanService {

	public Properties KafkaConfig() {
		String kafkaTopic = "test123";
		String brokers = "datanode02.cloudera.ph:9092,datanode03.cloudera.ph:9092";

		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
		props.put(ProducerConfig.RETRIES_CONFIG, "3");
		props.put("producer.type", "sync");
		props.put("batch.num.messages", "1");
		props.put(ProducerConfig.ACKS_CONFIG, "1");
		props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "none");
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, 1);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringSerializer");

		return props;
	}

	public String TopicKafka() {
		return "funesia";
	}
}
