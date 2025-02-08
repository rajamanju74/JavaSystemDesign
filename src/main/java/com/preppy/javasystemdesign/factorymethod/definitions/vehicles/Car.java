package com.preppy.javasystemdesign.factorymethod.definitions.vehicles;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Car extends Vehicle{
    Logger log = LoggerFactory.getLogger(Car.class);
    public void print(){
        log.info("This is a car");
    }
}
