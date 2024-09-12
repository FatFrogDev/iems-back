package com.fatfrogdev.iemsbackend.domain.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity { // TODO Add category entity?

    @Id
    @UuidGenerator
    private String productId;

    @NotBlank(message = "Product name is required.")
    @Size(min = 3, max = 50, message = "Product name must be between 3 and 100 characters.")
    @Column(nullable = false, length = 50)
    private String name;

    @Positive(message = "Product price must be greater than 0.")
    private Float releasePrice;

    private String website;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", referencedColumnName = "brandId")
    private BrandEntity brand;
}
