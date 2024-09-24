package com.fatfrogdev.iemsbackend.exceptions.file;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class FileHasNotValidExtensionException extends BaseException {
    public FileHasNotValidExtensionException(String message) {
        super(message);
    }
}