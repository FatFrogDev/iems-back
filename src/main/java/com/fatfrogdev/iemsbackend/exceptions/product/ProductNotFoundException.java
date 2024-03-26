package com.fatfrogdev.iemsbackend.exceptions.product;


import jakarta.persistence.EntityNotFoundException;

public class ProductNotFoundException extends EntityNotFoundException /* BaseException? */ {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
