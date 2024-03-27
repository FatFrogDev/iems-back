package com.fatfrogdev.iemsbackend.converters;

import com.fatfrogdev.iemsbackend.domain.DTOS.ProductDTO;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import static com.fatfrogdev.iemsbackend.converters.BaseConverter.baseMapper;

@Component
@Log4j2
public class ProductConverter {
    public ProductEntity registerDtoToEntity(ProductDTO productRegisterDTO) {
        try {
            return baseMapper().map(productRegisterDTO, ProductEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ProductDTO entityToDto(ProductEntity productEntity) {
        try {
            return baseMapper().map(productEntity, ProductDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
