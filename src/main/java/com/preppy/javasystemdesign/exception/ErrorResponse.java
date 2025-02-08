package com.preppy.javasystemdesign.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String message;
    private LocalDateTime time;
    private String detail;

    public ErrorResponse(String message, String detail){
        this.detail = detail;
        this.message = message;
    }


    @Override
    public String toString(){
        return "detail: "+this.detail+", \nmessage: "+this.message+", \ntime: "+LocalDateTime.now();
    }
}
