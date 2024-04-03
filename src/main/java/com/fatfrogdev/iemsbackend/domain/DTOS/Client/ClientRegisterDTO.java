package com.fatfrogdev.iemsbackend.domain.DTOS.Client;

import com.fatfrogdev.iemsbackend.domain.models.UserEntity;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRegisterDTO {

    private String name;

    private String countryAndCity;

    private int age;

    private String email;

    private String password;

    private String username;
}
