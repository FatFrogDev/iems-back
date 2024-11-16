package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, String> {

    Optional<CategoryEntity> findByCategoryName(String categoryName);

    @Query("select c.categoryName from CategoryEntity c")
    List<String> findAllCategoriesNames();

    boolean existsByCategoryName(String categoryName);
}