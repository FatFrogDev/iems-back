package com.fatfrogdev.iemsbackend.exceptions.client;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class ClientIsAlreadyActiveException extends BaseException {
    public ClientIsAlreadyActiveException(String message) {
        super(message);
    }
}
