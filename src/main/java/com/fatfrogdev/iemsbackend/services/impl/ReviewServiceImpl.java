package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.converters.ReviewConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.models.ReviewEntity;
import com.fatfrogdev.iemsbackend.repositories.IClientRepository;
import com.fatfrogdev.iemsbackend.repositories.IProductRepository;
import com.fatfrogdev.iemsbackend.repositories.IReviewRepository;
import com.fatfrogdev.iemsbackend.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewConverter reviewConverter;

    private final IReviewRepository reviewRepository;

    private final IProductRepository productRepository;

    private final IClientRepository clientRepository;

    @Override
    public ReviewEntity save(ReviewRegisterDTO reviewRegisterDTO) {
        return null;
    }

    @Override
    public ReviewEntity buildEntity(ReviewRegisterDTO reviewRegisterDTO) {
        return null;
    }

}
