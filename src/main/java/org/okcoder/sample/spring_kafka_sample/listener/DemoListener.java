package org.okcoder.sample.spring_kafka_sample.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DemoListener {

    private static final Logger logger = LoggerFactory.getLogger(DemoListener.class);

    @KafkaListener(topics = "test", groupId = "test")
    public void listen(Map<String, Object> body) {
        logger.info("Received: {}", body);
    }
}
