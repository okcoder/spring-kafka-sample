package org.okcoder.sample.spring_kafka_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.ProducerListener;

@SpringBootApplication
public class SpringKafkaSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaSampleApplication.class, args);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.kafka.template")
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory,
                                                       ProducerListener<String, String> producerListener) {
        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<String, String>(producerFactory);
        kafkaTemplate.setProducerListener(producerListener);
        return kafkaTemplate;
    }

}
