package org.okcoder.sample.spring_kafka_sample.logging;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.RecordInterceptor;
import org.springframework.stereotype.Component;

@Component
public class LoggingRecordInterceptor implements RecordInterceptor<Object, Object> {
    private static final Logger logger = LoggerFactory.getLogger(LoggingRecordInterceptor.class);

    @Override
    public ConsumerRecord<Object, Object> intercept(ConsumerRecord<Object, Object> record, Consumer<Object, Object> consumer) {

        logger.info("intercept record: {}", record);
        return record;
    }
}
