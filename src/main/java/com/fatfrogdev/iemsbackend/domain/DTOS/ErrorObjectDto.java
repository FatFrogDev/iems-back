package com.fatfrogdev.iemsbackend.domain.DTOS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ErrorObjectDto {

    private String timestamp;
    private HttpStatus code;
    private String exception;
    private String message;

}