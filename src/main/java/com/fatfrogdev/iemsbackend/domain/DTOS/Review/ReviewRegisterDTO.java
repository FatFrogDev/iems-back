package com.fatfrogdev.iemsbackend.domain.DTOS.Review;

import lombok.*;
import org.hibernate.type.descriptor.jdbc.DecimalJdbcType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRegisterDTO {

    private String title;

    private String productId;

    private String userId;

    private String content;

    private Float overallRating;

    private String overview;

    private String pros;

    private String contras;

    private MultipartFile[] images;
}