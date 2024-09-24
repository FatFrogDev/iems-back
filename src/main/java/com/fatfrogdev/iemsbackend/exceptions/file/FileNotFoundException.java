package com.fatfrogdev.iemsbackend.exceptions.file;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class FileNotFoundException extends BaseException {
    public FileNotFoundException(String message) {
        super(message);
    }
}