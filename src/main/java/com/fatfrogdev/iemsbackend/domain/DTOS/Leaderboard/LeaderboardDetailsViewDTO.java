package com.fatfrogdev.iemsbackend.domain.DTOS.Leaderboard;


import com.fatfrogdev.iemsbackend.domain.models.enumerates.ImagePrecision;
import com.fatfrogdev.iemsbackend.domain.models.enumerates.SoundStageAmplitude;
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
    private ImagePrecision imagePrecision;
    private boolean isBassHead;
    private boolean isFunny;
    private String mediumBassQualityQuantity;
    private String midRangeQualityQuantity;
    private String monitoringLiveStudio;
    private int productTop;
    private String sibilanceControl;
    private SoundStageAmplitude soundStageAmplitude;
    private String subBassQualityQuantity;
    private String videoGamesPerformance;

}
