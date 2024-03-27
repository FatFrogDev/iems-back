package com.fatfrogdev.iemsbackend.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.context.annotation.Conditional;

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
}
