package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.BrandEntity;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<ProductEntity, String>{

    Optional<ProductEntity> findByProductId(String string);

    Optional<List<ProductEntity>> findByNameStartingWith(String prefix);

    Optional<List<ProductEntity>> findByNameContaining(String containing);
}
