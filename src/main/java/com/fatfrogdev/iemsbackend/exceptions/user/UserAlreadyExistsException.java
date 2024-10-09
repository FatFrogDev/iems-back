package com.fatfrogdev.iemsbackend.exceptions.user;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class UserAlreadyExistsException extends BaseException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}