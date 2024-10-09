package com.fatfrogdev.iemsbackend.exceptions.product;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class ProductAlreadyHasReviewsException extends BaseException {
    public ProductAlreadyHasReviewsException(String message) {
        super(message);
    }
}