package com.wedding.api.service.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class GenerateResponse {
    public <T> ResponseEntity<T> generate(Object data, HttpStatus httpStatus, String message) {

        HashMap<String, Object> mapping = new HashMap<>();

        mapping.put("data", data);
        mapping.put("message", message);
        mapping.put("status", httpStatus.value());

        return new ResponseEntity<T>((T)mapping, httpStatus);
    }
}
