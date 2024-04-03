package com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard;

import com.fatfrogdev.iemsbackend.domain.models.enumerates.ImagePrecision;
import com.fatfrogdev.iemsbackend.domain.models.enumerates.SoundStageAmplitude;
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
    private SoundStageAmplitude soundStageAmplitude;
    private ImagePrecision imagePrecision;
    private String subBassQualityQuantity;
    private String bassQualityQuantity;
    private String mediumBassQualityQuantity;
    private String midRangeQualityQuantity;
    private String trebleQualityQuantity;
    private String sibilanceControl;
    private boolean isBassHead;
    private String monitoringLiveStudio;
    private boolean isFunny;
    private String videoGamesPerformance;
    private String buildQuality;
    private String comfort;
    private String cableQuality;
}