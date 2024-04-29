package com.fatfrogdev.iemsbackend.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "reviews_images")
public class ReviewImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewImageId;

    @ManyToOne
    private ReviewEntity review;

    @JoinColumn(name = "image_id")
    @OneToOne
    private MongoImageEntity mongoImage;

    public ReviewImageEntity(ReviewEntity review, MongoImageEntity mongoImage) {
        this.review = review;
        this.mongoImage = mongoImage;
    }
}
