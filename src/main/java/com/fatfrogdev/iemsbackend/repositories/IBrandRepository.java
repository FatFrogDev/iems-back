package com.fatfrogdev.iemsbackend.repositories;

import com.fatfrogdev.iemsbackend.domain.models.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBrandRepository extends JpaRepository<BrandEntity, String> {

    Optional<List<BrandEntity>> findByBrandIdStartsWith(String prefix);

    Optional<List<BrandEntity>> findByBrandIdContaining(String containing);
}
