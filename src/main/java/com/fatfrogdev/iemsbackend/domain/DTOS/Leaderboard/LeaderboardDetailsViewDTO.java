package com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard;

import lombok.*;


@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardDetailsViewDTO {
    private String productId;
    private String productName;
    private String productBrand;
    private String bassQualityQuantity;
    private String buildQuality;
    private String cableQuality;
    private String comfort;
    private String imagePrecision;
    private Boolean isBassHead;
    private Boolean isFunny;
    private String mediumBassQualityQuantity;
    private String midRangeQualityQuantity;
    private String monitoringLiveStudio;
    private Integer productTop;
    private String sibilanceControl;
    private String soundStageAmplitude;
    private String subBassQualityQuantity;
    private String videoGamesPerformance;
}