package com.preppy.javasystemdesign.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHadler {

    @ExceptionHandler(SystemDesignCustomException.class)
    public ResponseEntity<String> handleSpecificException(SystemDesignCustomException exception, WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), webRequest.getDescription(false));
        //return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse.toString());

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(
            Exception e, WebRequest request
    ){
        ErrorResponse response = new ErrorResponse(e.getMessage(), request.getDescription(false));
        //return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response.toString());
    }
}
