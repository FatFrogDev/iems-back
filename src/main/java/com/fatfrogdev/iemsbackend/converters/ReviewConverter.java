package com.fatfrogdev.iemsbackend.converters;

import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.ClientEntity;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;
import com.fatfrogdev.iemsbackend.domain.models.ReviewEntity;
import com.fatfrogdev.iemsbackend.domain.models.ReviewId;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import static com.fatfrogdev.iemsbackend.converters.BaseConverter.baseMapper;

@Component
@Log4j2
public class ReviewConverter {
    public ReviewEntity reviewRegisterDtoToEntity(ReviewRegisterDTO reviewRegisterDTO){
     try {
         return baseMapper().map(reviewRegisterDTO, ReviewEntity.class);
     }catch (Exception e) {
         e.getStackTrace();
         return null;
     }
    }


    public ReviewEntity reviewRegisterDtoToEntity(ReviewRegisterDTO reviewRegisterDTO, ProductEntity productEntity,
                                                  ClientEntity clientEntity, Integer reviewNumber) {
        try {
            ReviewEntity reviewEntity = reviewRegisterDtoToEntity(reviewRegisterDTO);
            if (reviewEntity!=null) {
                reviewEntity.setReviewId(new ReviewId(clientEntity, productEntity, reviewNumber));
                return reviewEntity;
            }else return null;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    public ReviewViewDTO entityToViewDto(ReviewEntity reviewEntity) {
        return ReviewViewDTO.builder()
                .brandId(reviewEntity.getReviewId().getProduct().getProductId())
                .productName(reviewEntity.getReviewId().getProduct().getName())
                .clientUsername(reviewEntity.getReviewId().getClient().getUser().getUsername())
                .reviewNumber(reviewEntity.getReviewId().getReviewNumber())
                .reviewTitle(reviewEntity.getReviewTitle())
                .content(reviewEntity.getContent())
                .overallRating(reviewEntity.getOverallRating())
                .overview(reviewEntity.getOverview())
                .pros(reviewEntity.getPros())
                .contras(reviewEntity.getContras())
                .build();
    }
}
