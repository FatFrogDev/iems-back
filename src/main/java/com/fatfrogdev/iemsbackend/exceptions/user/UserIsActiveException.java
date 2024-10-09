package com.fatfrogdev.iemsbackend.exceptions.user;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class UserIsActiveException extends BaseException {
    public UserIsActiveException(String message) {
        super(message);
    }
}
