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
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username must be alphanumeric.")
    private String username;

    // Makes the logical deletion of the user
    @Column(columnDefinition = "boolean default false", nullable = false)
    private boolean deleted;

    public UserEntity(String email, String password, String username){
        this.email = email;
        this.password = password;
        this.username = username;

    }
}
