package com.fatfrogdev.iemsbackend.domain.models.enumerates;


import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN,
    PAID_USER,
    USER,
    GUEST
}
