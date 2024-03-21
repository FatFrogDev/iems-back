package com.fatfrogdev.iemsbackend.models;

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
    private String brandId;

    private String filialOwner;
}
