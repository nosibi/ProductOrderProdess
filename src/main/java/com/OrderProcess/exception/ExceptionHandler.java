package com.OrderProcess.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validationExceptionHandler(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        Map<String, String> map = new HashMap<>();
        map.put("Error Type", httpStatus.getReasonPhrase());
        map.put("URI", request.getRequestURI());
        map.put("message", "유효하지 않은 데이터로 인한 예외 발생"+e.getMessage());
        return new ResponseEntity<>(map,httpHeaders,httpStatus);
    }

}
