package com.fatfrogdev.iemsbackend.exceptions.brand;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class BrandAlreadyHasProductsException extends BaseException {
    public BrandAlreadyHasProductsException(String message) {
        super(message);
    }
}
