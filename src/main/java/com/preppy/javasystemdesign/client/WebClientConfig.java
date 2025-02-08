package com.preppy.javasystemdesign.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.util.Map;

@Component
public class WebClientConfig {

    WebClient webClient;
    public WebClientConfig(WebClient.Builder builder){
        this.webClient = builder
                .baseUrl("https://api.openweathermap.org/data/2.5")
                .build();
    }

    public WebClient webClient(){
        return this.webClient;
    }
}
