package com.fatfrogdev.iemsbackend.exceptions.user;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class UserIsInactiveException extends BaseException {
    public UserIsInactiveException(String message) {
        super(message);
    }
}