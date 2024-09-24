package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.models.BrandEntity;

import java.util.List;
import java.util.Optional;

public interface IBrandService {

    BrandEntity save(BrandEntity brandEntity);

    BrandEntity findById(String brandId);

    List<BrandEntity> findAll(Integer page, Integer size);

    List<BrandEntity>  findByParam(String startsWith, String contains, String filialOwner);
}
