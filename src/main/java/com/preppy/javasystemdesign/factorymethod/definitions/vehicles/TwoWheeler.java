package com.preppy.javasystemdesign.factorymethod.definitions.vehicles;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TwoWheeler extends Vehicle{
    Logger log = LoggerFactory.getLogger(TwoWheeler.class);
    public void print(){
        log.info("This is a two wheeler");
    }
}
