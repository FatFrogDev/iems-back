package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.ReviewEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IReviewService {


    ReviewViewDTO save(ReviewRegisterDTO reviewRegisterDTO, List<MultipartFile> files);

    ReviewEntity buildEntity(ReviewRegisterDTO reviewRegisterDTO);

}
