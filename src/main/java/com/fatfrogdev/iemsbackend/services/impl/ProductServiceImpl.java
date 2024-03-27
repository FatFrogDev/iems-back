package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.converters.ProductConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.ProductDTO;
import com.fatfrogdev.iemsbackend.domain.models.BrandEntity;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;
import com.fatfrogdev.iemsbackend.repositories.IBrandRepository;
import com.fatfrogdev.iemsbackend.repositories.IProductRepository;
import com.fatfrogdev.iemsbackend.services.IBrandService;
import com.fatfrogdev.iemsbackend.services.IProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;

    private final IBrandService brandService;

    private final ProductConverter productConverter;


    @Override
    public ProductDTO save(ProductDTO productDTO) { //TODO: add product DTO or DTOS
        ProductEntity productEntity = productConverter.registerDtoToEntity(productDTO);
        BrandEntity optionalBrandEntity = brandService.findById(productDTO.getBrand());
        productEntity.setBrand(optionalBrandEntity);
        return productConverter.entityToDto(productRepository.save(productEntity));
    }

    @Override
    public ProductEntity findById(String productId) {
        return productRepository.findByProductId(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    @Override
    public List<ProductEntity> findByNameStartingWith(String prefix) {
        return productRepository.findByNameStartingWith(prefix).orElse(null);
    }

    @Override
    public List<ProductEntity> findByNameContaining(String containing) {
        return productRepository.findByNameContaining(containing).orElse(null);
    }
}
