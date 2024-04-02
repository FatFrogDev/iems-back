package com.fatfrogdev.iemsbackend.domain.DTOS;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardDetailsRegisterDTO {
    private String product;
    private String brand;
    private int productTop;
    private String soundStageAmplitude;
    private String imagePrecision;
    private String subBassQualityQuantity;
    private String bassQualityQuantity;
    private String mediumBassQualityQuantity;
    private String midRangeQualityQuantity;
    private String trebleQualityQuantity;
    private String sibilanceControl;
    private boolean isBassHead;
    private String monitoringLiveStudio;
    private boolean isFunny;
    private int videoGamesPerformance;
    private int buildQuality;
    private int comfort;
    private int cableQuality;
}
