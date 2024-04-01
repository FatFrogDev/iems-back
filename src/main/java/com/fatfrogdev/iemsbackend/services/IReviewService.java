package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.ReviewViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.ReviewEntity;

public interface IReviewService {


    ReviewViewDTO save(ReviewRegisterDTO reviewRegisterDTO);

    ReviewEntity buildEntity(ReviewRegisterDTO reviewRegisterDTO);

}
