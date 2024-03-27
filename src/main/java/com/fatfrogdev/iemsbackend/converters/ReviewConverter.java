package com.fatfrogdev.iemsbackend.converters;

import com.fatfrogdev.iemsbackend.domain.DTOS.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.models.ReviewEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import static com.fatfrogdev.iemsbackend.converters.BaseConverter.baseMapper;

@Component
@Log4j2
public class ReviewConverter {
    public ReviewEntity reviewRegisterDTOToReviewEntity(ReviewRegisterDTO reviewRegisterDTO){
     try {
         return baseMapper().map(reviewRegisterDTO, ReviewEntity.class);
     }catch (Exception e) {
         e.getStackTrace();
         return null;
     }
    }
}
