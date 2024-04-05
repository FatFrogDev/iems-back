package com.fatfrogdev.iemsbackend.domain.models.enumerates;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.core.convert.ConversionException;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.ConverterNotFoundException;

public enum ImagePrecision {
    SEEMS_REAL,
    VERY_REAL,
    NOTABLE,
    NORMAL,
    NOT_BAD,
    NOT_BAD_AT_ALL,
    BAD;

    public static ImagePrecision convertToImagePrecision(int value) {
        return switch (value) {
            case 0 -> ImagePrecision.SEEMS_REAL;
            case 1 -> ImagePrecision.VERY_REAL;
            case 2 -> ImagePrecision.NOTABLE;
            case 3 -> ImagePrecision.NORMAL;
            case 4 -> ImagePrecision.NOT_BAD;
            case 5 -> ImagePrecision.NOT_BAD_AT_ALL;
            case 6 -> ImagePrecision.BAD;
            default -> throw new IllegalArgumentException( "value " + value + "not supported to be converted");
        };
    }

}
