package com.fatfrogdev.iemsbackend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;


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
    private String userID;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Size(min = 7, max = 12, message = "Password must be between 7 and 12 characters.")
    @Column(nullable = false, length = 12)
    private String password;

    @Size(min = 3, max = 25, message = "Username must be between 3 and 50 characters.")
    @Column(nullable = false, length = 25, unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username must be alphanumeric.")
    private String username;
}
