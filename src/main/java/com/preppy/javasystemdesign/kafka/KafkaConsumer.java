package com.preppy.javasystemdesign.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Async
public class KafkaConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "my-topic1", groupId = "my-consumer-group")
    public void consumer(String message){
        logger.info("MESSAGE CONSUMED: {}", message);
    }
}
