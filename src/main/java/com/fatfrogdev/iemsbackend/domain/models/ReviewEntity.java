package com.fatfrogdev.iemsbackend.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class ReviewEntity {

    @Id
    @UuidGenerator
    private String reviewId;

    @NotBlank(message = "Review title is required.")
    @Column(nullable = false, length = 45)
    private String reviewTitle;

    @Size(max = 200, message = "Overview must be less than 200 characters.")
    @Column(length = 200)
    private String overview;

    @Column(columnDefinition = "text")
    private String content;

    @Size(max = 200, message = "Overview must be less than 200 characters.")
    @Column(length = 200)
    private String pros;

    @Size(max = 200, message = "Overview must be less than 200 characters.")
    @Column(length = 200)
    private String contras;

    @Column(nullable = false, columnDefinition = "decimal(2,1)")
    @Positive(message = "Rating must be greater than 0.")
    @Max(value = 5, message = "Rating must be less than 5.")
    private float overallRating;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(
            name = "review_images",
            joinColumns = @JoinColumn(name = "review_id"),
            inverseJoinColumns = @JoinColumn(name = "file_id")
    )
    private Set<FileEntity> images;
}