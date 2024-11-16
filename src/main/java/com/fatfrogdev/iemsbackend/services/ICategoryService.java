package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.models.CategoryEntity;

import java.util.List;

public interface ICategoryService {

    CategoryEntity save(CategoryEntity categoryEntity);

    List<String> findAll();

    CategoryEntity findByName(String categoryName);

    String formatCategoryName (String categoryName);
}