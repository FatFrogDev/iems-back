package com.fatfrogdev.iemsbackend.domain.models.enumerates;


import java.util.ArrayList;
import java.util.List;

public enum ImagePrecision {
    SEEMS_HOME_THEATER,
    SEEMS_REAL,
    REMARKABLE,
    NORMAL,
    NOT_PLEASANT,
    FLAT,
    BAD;

    public static ImagePrecision getImagePrecision(String imagePrecision){
        return switch (imagePrecision) {
            case "SEEMS_HOME_THEATER" -> SEEMS_HOME_THEATER;
            case "SEEMS_REAL" -> SEEMS_REAL;
            case "REMARKABLE" -> REMARKABLE;
            case "NORMAL" -> NORMAL;
            case "NOT_PLEASANT" -> NOT_PLEASANT;
            case "FLAT" -> FLAT;
            case "BAD" -> BAD;
            default -> throw new IllegalArgumentException("Invalid Image Precision");
        };
    }

    public static String getImagePrecision(ImagePrecision imagePrecision){
        return switch (imagePrecision) {
            case SEEMS_HOME_THEATER -> "SEEMS_HOME_THEATER";
            case SEEMS_REAL -> "SEEMS_REAL";
            case REMARKABLE -> "REMARKABLE";
            case NORMAL -> "NORMAL";
            case NOT_PLEASANT -> "NOT_PLEASANT";
            case FLAT -> "FLAT";
            case BAD -> "BAD";
        };
    }

    public static List<String> getImagePrecisionList(){
        List<String> possibleListValues = new ArrayList<>(ImagePrecision.values().length);
        for (ImagePrecision imagePrecision : ImagePrecision.values()){
            possibleListValues.add(imagePrecision.toString());
        }
        return possibleListValues;
    }
}