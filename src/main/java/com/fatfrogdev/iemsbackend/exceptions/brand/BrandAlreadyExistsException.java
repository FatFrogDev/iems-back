package com.fatfrogdev.iemsbackend.exceptions.brand;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class BrandAlreadyExistsException extends BaseException {
    public BrandAlreadyExistsException(String message) {
        super(message);
    }
}
