package com.fatfrogdev.iemsbackend.exceptions.product;

import com.fatfrogdev.iemsbackend.exceptions.BaseException;

public class ProductAlreadyExistsException extends BaseException {
        public ProductAlreadyExistsException(String message) {
            super(message);
        }
}