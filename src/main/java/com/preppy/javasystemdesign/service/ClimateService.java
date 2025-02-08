package com.preppy.javasystemdesign.service;

import com.preppy.javasystemdesign.client.WebClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ClimateService {
    Logger logger = LoggerFactory.getLogger(ClimateService.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClientConfig webClientConfig;
    public ResponseEntity<Object> getClimate(){
        ResponseEntity<Object> response = null;

        String url = "https://api.openweathermap.org";
        String uri = "/data/2.5/weather?lat=13.0827&lon=80.2707&appid=951ef0b58f2fc7d358267710dd9afe77";
        try {
            response = restTemplate.getForEntity(url + uri, Object.class);
        }catch(Exception e){
            logger.info("Caught exception: {}", e.getMessage());
        }
        return response;
    }
    public String getClimateAsync(){
        String uri = UriComponentsBuilder.fromPath("/weather")
                .queryParam("lat","13.0827")
                .queryParam("lon", "80.2707")
                .queryParam("appid", "951ef0b58f2fc7d358267710dd9afe77")
                .toUriString();
        String result = "";
        logger.info("uri: {}", uri);
        try {
            result = webClientConfig.webClient().get()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        }catch (Exception e){
            logger.info("Exception caught: {}", e.getMessage());
        }
        return result;
    }
}
