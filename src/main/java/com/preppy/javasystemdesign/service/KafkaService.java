package com.preppy.javasystemdesign.service;

import com.preppy.javasystemdesign.kafka.KafkaConsumer;
import com.preppy.javasystemdesign.kafka.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    Logger logger = LoggerFactory.getLogger(KafkaService.class);
    @Autowired
    public KafkaProducer producer;
    @Autowired
    public KafkaConsumer consumer;

    public ResponseEntity<String> produce(String message){
        try{
            producer.sendMessage(message);
        }catch (Exception e){
            logger.info("Exception caught while publishing to kafka: {}", e.getMessage());
            return new ResponseEntity<>("Message not published",HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity<>("Message published",HttpStatusCode.valueOf(200));
    }


}
