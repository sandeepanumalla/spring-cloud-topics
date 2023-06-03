package com.example.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class AddressControllerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public String noSuchElementException (NoSuchElementException noSuchElementException) {
        return noSuchElementException.getMessage();
    }
}
