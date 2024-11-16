package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.converters.ProductConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.Product.ProductDTO;
import com.fatfrogdev.iemsbackend.domain.models.BrandEntity;
import com.fatfrogdev.iemsbackend.domain.models.CategoryEntity;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;
import com.fatfrogdev.iemsbackend.exceptions.product.ProductNotFoundException;
import com.fatfrogdev.iemsbackend.repositories.IProductRepository;
import com.fatfrogdev.iemsbackend.services.IBrandService;
import com.fatfrogdev.iemsbackend.services.ICategoryService;
import com.fatfrogdev.iemsbackend.services.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;

    private final IBrandService brandService;

    private final ICategoryService categoryService;

    private final ProductConverter productConverter;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        BrandEntity optBrandEntity = brandService.findById(productDTO.getBrand());
        CategoryEntity optCategoryEntity = categoryService.findByName(productDTO.getCategory());
        ProductEntity productEntity = productConverter.registerDtoToEntity(productDTO);

        productEntity.setBrand(optBrandEntity);
        productEntity.setCategory(optCategoryEntity);
        return productConverter.entityToDto(productRepository.save(productEntity));
    }

    @Override
    public ProductEntity findById(String productId) {
        return productRepository.findByProductId(productId)
                .orElseThrow(() -> new ProductNotFoundException(String.format("Product with id %s not found", productId)));
    }

    @Override
    public List<ProductEntity> findByNameStartingWith(String prefix) {
        return productRepository.findByNameStartingWith(prefix)
                .orElseThrow(() -> new ProductNotFoundException(String.format("Error: Products starting with %s not found", prefix)));
    }

    @Override
    public List<ProductEntity> findByNameContaining(String containing) {
        return productRepository.findByNameContaining(containing)
                .orElseThrow(() -> new ProductNotFoundException(String.format("Error: Products containing %s not found", containing)));
    }

    @Override
    public List<ProductEntity> findAll(Integer page, Integer size) {
        page = (page != null && page >= 0) ? page : 0;
        size = (size != null && size >= 1) ? size : 10;
        return productRepository.findAllPaged(PageRequest.of(page, size));
    }

}