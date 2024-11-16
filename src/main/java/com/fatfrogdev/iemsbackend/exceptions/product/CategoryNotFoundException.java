package com.fatfrogdev.iemsbackend.exceptions.product;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class CategoryNotFoundException extends BaseException {

    public CategoryNotFoundException(String message) {
        super(message);
    }

}
