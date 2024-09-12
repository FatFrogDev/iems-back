package com.fatfrogdev.iemsbackend.domain.models;

import com.fatfrogdev.iemsbackend.domain.models.enumerates.ImagePrecision;
import com.fatfrogdev.iemsbackend.domain.models.enumerates.SoundStageAmplitude;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "leaderboards_details")
public class LeaderboardDetailsEntity {

    @Id
    @UuidGenerator
    private String LeaderboardDetailsId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "leaderboard_id", nullable = false)
    private LeaderboardEntity leaderboard;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @Column(nullable = false)
    private int productTop;

    @Column(nullable = false)
    private String soundStageAmplitude;

    @Column(nullable = false)
    private String imagePrecision;

    @Column(length = 5)
    private String subBassQualityQuantity;

    @Column(length = 5)
    private String bassQualityQuantity;

    @Column(length = 5)
    private String mediumBassQualityQuantity;

    @Column(length = 5)
    private String midRangeQualityQuantity;

    @Column(length = 5)
    private String trebleQualityQuantity;


    private String sibilanceControl;

    private boolean isBassHead;

    @Column(length = 5)
    private String monitoringLiveStudio;

    private boolean isFunny;

    private String videoGamesPerformance;

    private String buildQuality;

    private String comfort;

    private String cableQuality;
}
