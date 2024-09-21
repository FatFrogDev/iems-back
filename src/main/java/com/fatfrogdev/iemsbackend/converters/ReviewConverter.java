package com.fatfrogdev.iemsbackend.converters;

import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.*;
import com.fatfrogdev.iemsbackend.services.IFileService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;

import java.util.Set;

import static com.fatfrogdev.iemsbackend.converters.BaseConverter.baseMapper;

@AllArgsConstructor
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

    public ReviewEntity reviewRegisterDtoToEntity(ReviewRegisterDTO reviewRegisterDTO, ProductEntity productEntity, ClientEntity clientEntity, MultipartFile[] images) {
        try {
            ReviewEntity reviewEntity = reviewRegisterDtoToEntity(reviewRegisterDTO);
            if (reviewEntity==null)
                return null;
            reviewEntity.setReviewId(new ReviewId(clientEntity, productEntity));

            if (images == null)
                return reviewEntity;

            Set<FileEntity> fileEntities = new HashSet<>();
            for (MultipartFile image : images) {
                fileEntities.add(FileEntity.builder()
                        .name(image.getOriginalFilename())
                        .type(image.getContentType())
                        .data(image.getBytes())
                        .build());
            }
            reviewEntity.setImages(fileEntities);
            return reviewEntity;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }


    public ReviewViewDTO entityToViewDto(ReviewEntity reviewEntity) {
        return ReviewViewDTO.builder()
                .brandId(reviewEntity.getReviewId().getProduct().getBrand().getBrandId())
                .productName(reviewEntity.getReviewId().getProduct().getName())
                .clientUsername(reviewEntity.getReviewId().getClient().getUser().getUsername())
                .reviewTitle(reviewEntity.getReviewTitle())
                .content(reviewEntity.getContent())
                .overallRating(reviewEntity.getOverallRating())
                .overview(reviewEntity.getOverview())
                .pros(reviewEntity.getPros())
                .contras(reviewEntity.getContras())
                .build();
    }
}
