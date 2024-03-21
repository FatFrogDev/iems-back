package com.fatfrogdev.iemsbackend.models;

import com.fatfrogdev.iemsbackend.models.enumerates.ImagePrecision;
import com.fatfrogdev.iemsbackend.models.enumerates.SoundStageAmplitude;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "califications_tables")
public class CalificationTableEntity {
    @Id
    @UuidGenerator
    private String calificationTableId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "calification_table_details_id")
    private CalificationTableDetailsEntity calificationTableDetailsEntity;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private PersonEntity person;


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

    private int videogamesPerformance;

    private int buildQuality;

    private int comfort;

    private int cable_quality;

}


