package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<ProductEntity, String>{

    Optional<ProductEntity> findByProductId(String string);

    Optional<List<ProductEntity>> findByNameStartingWith(String prefix);

    Optional<List<ProductEntity>> findByNameContaining(String containing);

    //boolean existsByProductIdAndBrand_BrandId(String productId, String brandId);

    Optional<ProductEntity> findByNameAndBrand_BrandId(String productId, String brandId);

    @Query("SELECT pdt.productId FROM ProductEntity pdt WHERE pdt.name=:productname AND pdt.brand.brandId =:product_brand")
    Optional<String> findProductIdByProductNameAndProductBrand(@Param("product_name") String productName, @Param("product_brand") String productBrand);
}
