package com.fatfrogdev.iemsbackend.exceptions.client;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class ClientWasAlreadyDeactivatedException extends BaseException {
    public ClientWasAlreadyDeactivatedException(String message) {
        super(message);
    }
}