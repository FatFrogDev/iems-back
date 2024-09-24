package com.fatfrogdev.iemsbackend.exceptions.client;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class ClientNotFoundException extends BaseException {
    public ClientNotFoundException(String message) {
        super(message);
    }
}