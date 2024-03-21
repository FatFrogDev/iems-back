package com.fatfrogdev.iemsbackend.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "people")
public class PersonEntity {
    @Id
    @UuidGenerator
    private String personId;

    private String name;

    private String countryCity;

    private int age;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
