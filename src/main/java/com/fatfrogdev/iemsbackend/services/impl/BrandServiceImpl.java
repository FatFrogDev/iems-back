package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.domain.models.BrandEntity;
import com.fatfrogdev.iemsbackend.repositories.IBrandRepository;
import com.fatfrogdev.iemsbackend.services.IBrandService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandServiceImpl implements IBrandService {

    private final IBrandRepository brandRepository;

    @Override
    public BrandEntity save(BrandEntity brandEntity) {
        return brandRepository.save(brandEntity);
    }

    @Override
    public BrandEntity findById(String brandId) { // TODO: add brand not found exception.
        return brandRepository.findById(brandId).orElseThrow(() -> new EntityNotFoundException("Brand not found"));
    }

    @Override
    public List<BrandEntity> findByBrandIdStartsWith(String prefix) {
        return brandRepository.findByBrandIdStartsWith(prefix).orElse(null);
    }

    @Override
    public List<BrandEntity> findByBrandIdContaining(String containing) {
        return brandRepository.findByBrandIdContaining(containing).orElse(null);
    }
}
