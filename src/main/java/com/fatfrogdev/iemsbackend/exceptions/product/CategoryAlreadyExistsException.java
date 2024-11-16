package com.fatfrogdev.iemsbackend.exceptions.product;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class CategoryAlreadyExistsException extends BaseException {

    public CategoryAlreadyExistsException(String message) {
        super(message);
    }
    
}
