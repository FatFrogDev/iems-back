package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.domain.models.CategoryEntity;
import com.fatfrogdev.iemsbackend.exceptions.product.CategoryAlreadyExistsException;
import com.fatfrogdev.iemsbackend.exceptions.product.CategoryNotFoundException;
import com.fatfrogdev.iemsbackend.repositories.ICategoryRepository;
import com.fatfrogdev.iemsbackend.services.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    @Override
    public CategoryEntity save(CategoryEntity categoryEntity){
        categoryEntity.setCategoryName(this.formatCategoryName(categoryEntity.getCategoryName()));

        boolean categoryExists = categoryRepository.existsByCategoryName(categoryEntity.getCategoryName());

        if(categoryExists)
            throw new CategoryAlreadyExistsException(String.format("Category with name %s already exists.", categoryEntity.getCategoryName()));
        
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public List<String> findAll() {
        return categoryRepository.findAllCategoriesNames();
    }

    @Override
    public CategoryEntity findByName(String categoryName) {
        return categoryRepository.findByCategoryName(this.formatCategoryName(categoryName))
                .orElseThrow(()->new CategoryNotFoundException(String.format("Category with name %s not found.", categoryName)));
    }

    @Override
    public String formatCategoryName(String categoryName){
        return categoryName
        .strip().toLowerCase()
        .replace("", "-");
    }
}