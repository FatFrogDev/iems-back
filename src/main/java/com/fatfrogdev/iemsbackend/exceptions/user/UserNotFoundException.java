package com.fatfrogdev.iemsbackend.exceptions.user;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(String message) {
        super(message);
    }
}