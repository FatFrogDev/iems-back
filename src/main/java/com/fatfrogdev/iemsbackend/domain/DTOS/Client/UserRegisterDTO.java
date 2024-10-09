package com.fatfrogdev.iemsbackend.domain.DTOS.Client;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {

    private String name;

    private String country;

    private int age;

    private String email;

    private String password;

    private String username;
}
