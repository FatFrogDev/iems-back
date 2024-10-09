package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.domain.models.CategoryEntity;
import com.fatfrogdev.iemsbackend.repositories.ICategoryRepository;
import com.fatfrogdev.iemsbackend.services.ICategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    @Override
    public CategoryEntity save(CategoryEntity categoryEntity){ // ToDo: Add RegExp validators. CATEGORY  OR CA-TE-GO-RY SHOULD BE VALID
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public List<String> findAll() {
        return categoryRepository.findAllCategoriesNames();
    }

    @Override
    public CategoryEntity findByName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName)
                .orElseThrow(()->new EntityNotFoundException(String.format("Category with name %s not found.", categoryName)));
    }
}