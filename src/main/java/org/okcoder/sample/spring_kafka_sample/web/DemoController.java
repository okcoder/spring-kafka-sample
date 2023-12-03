package org.okcoder.sample.spring_kafka_sample.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    private final KafkaTemplate<String, String> template;

    public DemoController(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @PostMapping("/send")
    public void test() {
        Map<String, Object> value = Map.of("name", "foo", "now", System.currentTimeMillis());
        logger.info("sending value: {}", value);
        Message<Map<String, Object>> message = MessageBuilder.withPayload(value)
                .setHeader(KafkaHeaders.TOPIC, "test")
                .build();
        template.send(message);
        logger.info("sent value: {}", value);
    }
}
