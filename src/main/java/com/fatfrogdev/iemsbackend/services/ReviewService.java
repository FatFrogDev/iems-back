package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.models.ReviewEntity;

public interface ReviewService {
    ReviewEntity save(ReviewRegisterDTO reviewRegisterDTO);

    ReviewEntity buildEntity(ReviewRegisterDTO reviewRegisterDTO);
}
