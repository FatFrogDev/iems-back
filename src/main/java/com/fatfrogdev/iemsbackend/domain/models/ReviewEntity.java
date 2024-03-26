package com.fatfrogdev.iemsbackend.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class ReviewEntity {

    @Id
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ClientEntity client;

    @Id
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductEntity product;

    @Id
    @Column(columnDefinition = "boolean not null default false")
    private boolean isSecondReview;

    @Column(nullable = false)
    private String content;

    @Positive(message = "Rating must be greater than 0.")
    private float rating;

    private String overview;

    private String pros;

    private String contras;
}
