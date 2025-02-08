package com.preppy.javasystemdesign.controller;

import com.preppy.javasystemdesign.exception.ErrorResponse;
import com.preppy.javasystemdesign.exception.SystemDesignCustomException;
import com.preppy.javasystemdesign.service.ClimateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/climate/india")
@RestController
@Tag(name = "Climate", description = "Shows climate in sync and async methods")
@CrossOrigin(origins = "frontend.com", allowedHeaders = "content-type, etc",
        allowCredentials = "true")
public class ClimateController {

    //Cross Origin - mentions which applns can access this APIs with which headers and credentials
    //protects the backend and makes the browser allow the call from frontend to backend
    /*
    *
    * CORS Response from Backend
    *   Access-Control-Allow-Origin: http://frontend.com
        Access-Control-Allow-Methods: GET, POST
        Access-Control-Allow-Headers: Content-Type
        Access-Control-Allow-Credentials: true
    * */
    @Autowired
    private ClimateService climateService;

    @GetMapping
    @Operation(summary = "Get climate sync", description = "Get climate sync in Chennai center")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved climate"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Object> getClimateIndia(){
        return climateService.getClimate();
    }
    @GetMapping("/async")
    @Operation(summary = "Get Climate Async", description = "Get Chennai center climate asynchronously")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Got response successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public String getClimateAsync(){
        return climateService.getClimateAsync();
    }

    @GetMapping("/check")
    @Operation(summary = "Check Global Exception handler", description = "Throws exception - no other purpose")
    @ApiResponse(responseCode = "400", description = "Bad request")
    public ResponseEntity<String> check(){
        throw new SystemDesignCustomException("Simulated exception");
    }
}
