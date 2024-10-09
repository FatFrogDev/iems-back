package com.fatfrogdev.iemsbackend.domain.DTOS.Review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRegisterDTO {

    @NotBlank(message = "Title is required.")
    private String title;

    @NotNull(message = "Product is required.")
    private String product;

    @Pattern(regexp = "^[a-z0-9]*$", message = "Username must contain only lower letters and numbers.")
    private String user;

    private String content;

    private Float overallRating;

    private String overview;

    private String pros;

    private String contras;

    private MultipartFile[] images;
}