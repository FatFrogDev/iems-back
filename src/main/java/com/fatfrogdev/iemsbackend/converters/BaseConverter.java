package com.fatfrogdev.iemsbackend.converters;

import org.modelmapper.ModelMapper;


public class BaseConverter {
    public static ModelMapper baseMapper(){
        return  new ModelMapper();
    }
}
