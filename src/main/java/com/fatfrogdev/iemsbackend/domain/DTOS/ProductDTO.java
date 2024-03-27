package com.fatfrogdev.iemsbackend.domain.DTOS;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String brand;
    private String name;
    private Float releasePrice;
    private String website;
}
