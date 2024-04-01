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
    private String reviewTitle;

    @Column(columnDefinition = "text")
    private String content;

    @Column(nullable = false, precision = 1, columnDefinition = "decimal(2,1)")
    @Positive(message = "Rating must be greater than 0.")
    @Max(value = 5, message = "Rating must be less than 5.")
    private Float overallRating;

    @Size(max = 200, message = "Overview must be less than 200 characters.")
    @Column(length = 200)
    private String overview;

    @Size(max = 200, message = "Overview must be less than 200 characters.")
    @Column(length = 200)
    private String pros;

    @Size(max = 200, message = "Overview must be less than 200 characters.")
    @Column(length = 200)
    private String contras;
}
