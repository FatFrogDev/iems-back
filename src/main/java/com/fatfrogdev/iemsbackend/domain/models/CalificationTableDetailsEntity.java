package com.fatfrogdev.iemsbackend.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "calification_table_details")
@Table(name = "calification_table_details")
public class CalificationTableDetailsEntity {

    @Id
    @UuidGenerator
    private String calificationTableDetailsId;

    @Column(nullable = false)
    private String content;

    @Positive(message = "Rating must be greater than 0.")
    private float rating;

    private String overview;

    private String pros;

    private String contras;
}
