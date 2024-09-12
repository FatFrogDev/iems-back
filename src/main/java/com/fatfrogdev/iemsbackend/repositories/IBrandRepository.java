package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IBrandRepository extends JpaRepository<BrandEntity, String> {

    List<BrandEntity> findByBrandIdStartsWith(String prefix);

    List<BrandEntity> findByBrandIdContaining(String containing);

    List<BrandEntity> findByFilialOwner(String filialOwner);

    @Query("select b from BrandEntity b")
    List<BrandEntity> findAllPaged(Pageable pageable);
}