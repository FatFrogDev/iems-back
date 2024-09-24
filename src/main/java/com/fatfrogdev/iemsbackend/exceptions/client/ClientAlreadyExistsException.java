package com.fatfrogdev.iemsbackend.exceptions.client;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class ClientAlreadyExistsException extends BaseException {
    public ClientAlreadyExistsException(String message) {
        super(message);
    }
}