package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.domain.models.BrandEntity;
import com.fatfrogdev.iemsbackend.exceptions.WrongArgumentsException;
import com.fatfrogdev.iemsbackend.exceptions.brand.BrandNotFoundException;
import com.fatfrogdev.iemsbackend.repositories.IBrandRepository;
import com.fatfrogdev.iemsbackend.services.IBrandService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BrandServiceImpl implements IBrandService {

    private final IBrandRepository brandRepository;

    @Override
    public BrandEntity save(BrandEntity brandEntity) {
        return brandRepository.save(brandEntity);
    }

    @Override
    public List<BrandEntity> findAll(Integer page, Integer size) {
        page = (page != null && page >= 0) ? page : 0;
        size = (size != null && size >= 1) ? size : 10;
        return brandRepository.findAllPaged(PageRequest.of(page, size));
    }

    @Override
    public BrandEntity findById(String brandId) {
        return brandRepository.findById(brandId)
                .orElseThrow(() -> new BrandNotFoundException(String.format("Error: Brand with id %s not found", brandId)));
    }

    @Override
    public List<BrandEntity> findByParam(String startsWith, String contains, String filialOwner) {
        if (startsWith != null) {
            return findByBrandIdStartsWith(startsWith);
        } else if (contains != null) {
            return findByBrandIdContaining(contains);
        } else if (filialOwner != null) {
            return brandRepository.findByFilialOwner(filialOwner);
        } else
            throw new WrongArgumentsException("Error: No valid parameters passed");
    }

    private List<BrandEntity> findByBrandIdStartsWith(String prefix) {
        return brandRepository.findByBrandIdStartsWith(prefix);
    }

    private List<BrandEntity> findByBrandIdContaining(String containing) {
        return brandRepository.findByBrandIdContaining(containing);
    }

    private List<BrandEntity> findByFilialOwner(String containing) {
        return brandRepository.findByFilialOwner(containing);
    }
}