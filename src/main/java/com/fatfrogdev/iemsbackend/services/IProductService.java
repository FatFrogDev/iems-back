package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.Product.ProductDTO;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;

import java.util.List;

public interface IProductService {
    ProductDTO save(ProductDTO productRegisterDTO);

    ProductEntity findById(String productId);

    List<ProductEntity> findByNameStartingWith(String prefix);

    List<ProductEntity> findByNameContaining(String containing);

    List<ProductEntity> findAll();
}
