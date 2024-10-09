package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewViewDTO;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IReviewService {

    ReviewViewDTO saveWithoutImages(ReviewRegisterDTO reviewRegisterDTO, MultipartFile[] images);

    void saveReviewImages(String reviewId, MultipartFile[] images) throws IOException;

    void deleteReview(String reviewId);

    @Transactional
    void deleteReviewImages(String reviewId, String imageId);

    ReviewViewDTO findReviewById(String reviewId);
}
