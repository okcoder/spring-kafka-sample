package org.okcoder.sample.spring_kafka_sample.logging;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class LoggingProducerListener implements ProducerListener<String, String> {
    private static final Logger logger = LoggerFactory.getLogger(LoggingProducerListener.class);

    @Override
    public void onSuccess(ProducerRecord<String, String> producerRecord, RecordMetadata recordMetadata) {
        producerRecord.headers().forEach(header -> logger.info("header: {}->{}", header.key(), new String(header.value())));
        logger.info("onSuccess: producerRecord: {}, recordMetadata: {}", producerRecord, recordMetadata);
    }

    @Override
    public void onError(ProducerRecord<String, String> producerRecord,
                        @Nullable RecordMetadata recordMetadata, Exception exception) {
        logger.error("onError: producerRecord: {}, exception: {}", producerRecord, exception);
    }
}
