package com.fatfrogdev.iemsbackend.exceptions.review;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class ReviewNotFoundException extends BaseException {
    public ReviewNotFoundException(String message) {
        super(message);
    }
}