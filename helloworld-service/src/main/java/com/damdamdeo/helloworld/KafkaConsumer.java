package com.damdamdeo.helloworld;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.concurrent.CompletionStage;
import io.smallrye.reactive.messaging.kafka.KafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Incoming("helloworld")
    @Transactional
    public CompletionStage<Void> onMessage(final KafkaMessage<String, String> message) {
        LOGGER.info("Received message " + message.getPayload());
        return message.ack();
    }

}
