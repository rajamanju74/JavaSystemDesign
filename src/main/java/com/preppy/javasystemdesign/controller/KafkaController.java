package com.preppy.javasystemdesign.controller;

import com.preppy.javasystemdesign.service.KafkaService;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    KafkaService service;
    @PostMapping("/{message}")
    public ResponseEntity<String> publish(@PathVariable @Nonnull String message){
        return service.produce(message);
    }
}
