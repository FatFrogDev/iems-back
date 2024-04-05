package com.fatfrogdev.iemsbackend.domain.models.enumerates;

public enum SoundStageAmplitude {
    THE_WIDER,
    VERY_WIDE,
    NOTABLE,
    NORMAL,
    NOT_BAD,
    NOT_BAD_AT_ALL,
    BAD;

    public static SoundStageAmplitude convertToSoundStageAmplitude(int value) {
        return switch (value) {
            case 0 -> SoundStageAmplitude.THE_WIDER;
            case 1 -> SoundStageAmplitude.VERY_WIDE;
            case 2 -> SoundStageAmplitude.NOTABLE;
            case 3 -> SoundStageAmplitude.NORMAL;
            case 4 -> SoundStageAmplitude.NOT_BAD;
            case 5 -> SoundStageAmplitude.NOT_BAD_AT_ALL;
            case 6 -> SoundStageAmplitude.BAD;
            default -> throw new IllegalArgumentException("value " + value + "not supported to be converted");
        };
    }
}
