package com.fatfrogdev.iemsbackend.domain.models;

import jakarta.persistence.*;
import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "brands")
public class BrandEntity {
    @Id
    @Column(nullable = false, length = 35)
    private String brandId;

    @Column(length = 45)
    private String filialOwner;

    public BrandEntity(String brandId) {
        this.brandId = brandId;
    }
}
