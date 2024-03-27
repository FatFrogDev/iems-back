package com.fatfrogdev.iemsbackend.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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

    @Column(nullable = false)
    private String content;

    @Positive(message = "Rating must be greater than 0.")
    private float rating;

    private String overview;

    private String pros;

    private String contras;
}
