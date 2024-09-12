package com.fatfrogdev.iemsbackend.domain.models.enumerates;

import java.util.ArrayList;
import java.util.List;

public enum SoundStageAmplitude {
    EXCEPTIONAL,
    VERY_WIDE,
    WIDE,
    NORMAL,
    UNDER_AVERAGE,
    NARROW,
    BAD;

    public static SoundStageAmplitude getSoundStageAmplitude(String soundStageAmplitude){
        return switch (soundStageAmplitude) {
            case "EXCEPTIONAL" -> EXCEPTIONAL;
            case "VERY_WIDE" -> VERY_WIDE;
            case "WIDE" -> WIDE;
            case "NORMAL" -> NORMAL;
            case "UNDER_AVERAGE" -> UNDER_AVERAGE;
            case "NARROW" -> NARROW;
            case "BAD" -> BAD;
            default -> throw new IllegalArgumentException("Invalid Sound Stage Amplitude");
        };
    }

    public static String getSoundStageAmplitude(SoundStageAmplitude soundStageAmplitude){
        return switch (soundStageAmplitude) {
            case EXCEPTIONAL -> "EXCEPTIONAL";
            case VERY_WIDE -> "VERY_WIDE";
            case WIDE -> "WIDE";
            case NORMAL -> "NORMAL";
            case UNDER_AVERAGE -> "UNDER_AVERAGE";
            case NARROW -> "NARROW";
            case BAD -> "BAD";
        };
    }

    public static List<String> getSoundStageAmplitudeList(){
        List<String> possibleListValues = new ArrayList<>(SoundStageAmplitude.values().length);
        for (SoundStageAmplitude soundStageAmplitude : SoundStageAmplitude.values()){
            possibleListValues.add(soundStageAmplitude.toString());
        }
        return possibleListValues;
    }
}