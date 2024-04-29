package com.fatfrogdev.iemsbackend.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class ReviewEntity {

    @EmbeddedId
    private ReviewId reviewId;

    @NotBlank(message = "Review title is required.")
    @Column(nullable = false, length = 45)
    private String tittle;

    @Column(columnDefinition = "text")
    private String content;

    @Size(max = 200, message = "pros must be less than 200 characters.")
    @Column(length = 200)
    private String pros;

    @Size(max = 200, message = "cons must be less than 200 characters.")
    @Column(length = 200)
    private String contras;

    @Size(max = 250, message = "Equipment test specifications can't exceed 250 characters of length.")
    private String equipmentSpecs;

    @Size(max = 250, message = "Overview must be less or equals to 250 characters.")
    private String conclusion;

    @Column(columnDefinition = "JSON")
    private String performedTracks; //TODO -> Add impl to handle json data type. DTO can get a list of strings.
}
