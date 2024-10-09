package com.fatfrogdev.iemsbackend.exceptions.review;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class ReviewAlreadyExistsException extends BaseException {
    public ReviewAlreadyExistsException(String message) {
        super(message);
    }
}