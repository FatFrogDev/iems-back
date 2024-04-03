package com.fatfrogdev.iemsbackend.domain.DTOS.Review;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewViewDTO {

    private String brandId;

    private String productName;

    private String clientUsername;

    private int reviewNumber;

    private String reviewTitle;

    private String content;

    private Float overallRating;

    private String overview;

    private String pros;

    private String contras;

}
