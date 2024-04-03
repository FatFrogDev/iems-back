package com.fatfrogdev.iemsbackend.domain.DTOS.Client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientViewDTO {

    private String name;
    private String countryAndCity;
    private int age;
    private String email;
    private String username;

}
