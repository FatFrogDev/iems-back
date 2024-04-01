package com.fatfrogdev.iemsbackend.domain.models;

import com.fatfrogdev.iemsbackend.domain.models.enumerates.ImagePrecision;
import com.fatfrogdev.iemsbackend.domain.models.enumerates.SoundStageAmplitude;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "calification_table_details")
public class LeaderboardDetailsEntity {

    @Id
    @UuidGenerator
    private String LeaderboardDetailsId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LeaderboardEntity leaderboard;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;


    @Column(nullable = false)
    private int productTop;

    private String brand;

    private SoundStageAmplitude soundStageAmplitude;

    private ImagePrecision imagePrecision;

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

    // private boolean isFatiguing;

    private int videoGamesPerformance;

    private int buildQuality;

    private int comfort;

    private int cableQuality;
}