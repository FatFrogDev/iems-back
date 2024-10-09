package com.fatfrogdev.iemsbackend.domain.DTOS.Product;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String brand;
    private String name;
    private String category;
    private Float releasePrice;
    private String website;
}
