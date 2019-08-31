package com.damdamdeo.helloworld;

import io.quarkus.test.junit.QuarkusTest;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@QuarkusTest
public class KafkaConsumerAppTest {

    @ConfigProperty(name = "smallrye.messaging.source.helloworld.bootstrap.servers")
    String servers;

    @Test
    public void produceHello() throws Exception {
        final Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.ACKS_CONFIG, "1");
        final KafkaProducer<String, String> producer = new KafkaProducer(config);

        producer.send(new ProducerRecord<>("helloworld", "key", "Hello Quarkus !")).get();

        Thread.sleep(1000l);
    }

}
