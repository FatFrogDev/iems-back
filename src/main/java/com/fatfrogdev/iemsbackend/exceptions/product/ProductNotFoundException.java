package com.fatfrogdev.iemsbackend.exceptions.product;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class ProductNotFoundException extends BaseException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}