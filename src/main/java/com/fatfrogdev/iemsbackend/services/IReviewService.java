package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.ReviewEntity;
import com.fatfrogdev.iemsbackend.domain.models.ReviewId;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IReviewService {


    ReviewViewDTO saveWithoutImages(ReviewRegisterDTO reviewRegisterDTO, MultipartFile[] images);

    void saveReviewImages(String clientId, String productId, MultipartFile[] images) throws IOException;

    void deleteReview(String clientId, String productId);

    @Transactional
    void deleteReviewImages(String clientId, String productId, String imageId);
}
