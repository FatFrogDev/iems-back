package com.fatfrogdev.iemsbackend.exceptions.brand;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class BrandNotFoundException extends BaseException {
    public BrandNotFoundException(String message) {
        super(message);
    }
}