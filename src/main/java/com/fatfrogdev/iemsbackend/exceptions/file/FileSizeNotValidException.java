package com.fatfrogdev.iemsbackend.exceptions.file;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class FileSizeNotValidException extends BaseException {
    public FileSizeNotValidException(String message) {
        super(message);
    }
}