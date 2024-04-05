package com.fatfrogdev.iemsbackend.domain.DTOS;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorObject {
        private HttpStatus code;
        private String timestamp;
        private String description;
        private String exception;
        private Object[] errors;
}


