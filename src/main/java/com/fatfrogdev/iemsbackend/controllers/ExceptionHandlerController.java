package com.fatfrogdev.iemsbackend.controllers;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class ExceptionHandlerController {

    private static final DateTimeFormatter format =  DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private static final String date = LocalDateTime.now().format(format);


}
