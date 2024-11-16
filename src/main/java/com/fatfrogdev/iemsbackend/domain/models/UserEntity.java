package com.fatfrogdev.iemsbackend.domain.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @UuidGenerator
    private String userId;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Size(min = 7, max = 255, message = "Password must be between 7 and 12 characters.")
    @Column(nullable = false)
    private String password;

    @Size(min = 3, max = 25, message = "Username must be between 3 and 50 characters.")
    @Column(nullable = false, length = 25, unique = true)
    @Pattern(regexp = "^[a-z0-9]*$", message = "Username must be alphanumeric.")
    private String username;

    @Size(min = 1, max = 60, message = "Name must be between 1 and 50 characters.") // ToDo: Validate Regex with dto validator
    private String name;

    @Size(max = 3, message = "Country follows ISO 3166 standard. Ex: USA, COL, MEX")
    @Pattern(regexp = "[A-Z]{3}")
    private String country;

    private Integer age; // TODO : ADD validation

    @Column(nullable = false, columnDefinition = "boolean not null default true")
    private boolean active;


    public UserEntity(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;

    }

    public UserEntity(String userId) {
        this.userId = userId;
    }

    public UserEntity(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }
}