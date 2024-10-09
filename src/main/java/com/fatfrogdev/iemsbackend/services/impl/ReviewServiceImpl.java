package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.converters.ReviewConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.*;
import com.fatfrogdev.iemsbackend.exceptions.user.UserNotFoundException;
import com.fatfrogdev.iemsbackend.exceptions.file.FileHasNotValidExtensionException;
import com.fatfrogdev.iemsbackend.exceptions.file.FileNotFoundException;
import com.fatfrogdev.iemsbackend.exceptions.file.FileSizeNotValidException;
import com.fatfrogdev.iemsbackend.exceptions.product.ProductNotFoundException;
import com.fatfrogdev.iemsbackend.exceptions.review.ReviewNotFoundException;
import com.fatfrogdev.iemsbackend.repositories.IProductRepository;
import com.fatfrogdev.iemsbackend.repositories.IReviewRepository;
import com.fatfrogdev.iemsbackend.repositories.IUserRepository;
import com.fatfrogdev.iemsbackend.services.IFileService;
import com.fatfrogdev.iemsbackend.services.IReviewService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements IReviewService {

    private final ReviewConverter reviewConverter; private final IReviewRepository reviewRepository;

    private final IProductRepository productRepository;

    private final IUserRepository userRepository;

    private IFileService fileService;

    @Override
    public ReviewViewDTO saveWithoutImages(ReviewRegisterDTO reviewRegisterDTO, MultipartFile[] images) {
        ReviewEntity reviewEntity = buildEntity(reviewRegisterDTO, images);

        return reviewConverter.entityToViewDto(
                    reviewRepository.save(reviewEntity)
            );
    }

    @Override
    public void saveReviewImages(String reviewId, MultipartFile[] images) throws IOException {
        ReviewEntity reviewEntity = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException("Error: review with given id not found."));

        Set<FileEntity> reviewImages = new HashSet<>();

        for (MultipartFile image : images) {
            if (fileService.hasValidImageExtension(image.getOriginalFilename(), (String[]) null))
                throw new FileHasNotValidExtensionException("Error: invalid image extension. Review not saved.");

            if (!fileService.imageHasValidSize(image))
                throw new FileSizeNotValidException(String.format("Error: Image %s size exceeds the limit of 10MB. Review not saved.", image.getOriginalFilename()));

            reviewImages.add(
                    new FileEntity(image.getOriginalFilename(), image.getContentType(), image.getBytes())
            );
        }       reviewEntity.setImages(reviewImages);
                reviewRepository.save(reviewEntity);
    }

    @Override
    public void deleteReview(String reviewId) {
        boolean reviewExists = reviewRepository.existsById(reviewId);
        if (!reviewExists)
            throw new ReviewNotFoundException("Error: Review with given id not found.");
        else
            reviewRepository.deleteById(reviewId);
    }

    @Transactional
    @Override
    public void deleteReviewImages(String reviewId, String imageId) {
        ReviewEntity reviewEntity = reviewRepository.findById(reviewId)
                .orElseThrow(()-> new ReviewNotFoundException("Error: Review with given id not found."));

        FileEntity image = reviewEntity.getImages().stream()
                .filter(file -> file.getFileId().equals(imageId))
                .findFirst()
                .orElseThrow(()-> new FileNotFoundException(String.format("Image with id %s not found.", imageId)));

        reviewEntity.getImages().remove(image);
        reviewRepository.save(reviewEntity);

        fileService.deleteImageById(imageId);
    }

    @Transactional
    @Override
    public ReviewViewDTO findReviewById(String reviewId) {
        ReviewEntity reviewEntity = reviewRepository.findByReviewId(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException("Error: Review with given id not found."));

        return reviewConverter.entityToViewDto(reviewEntity);
    }

    private ReviewEntity buildEntity(ReviewRegisterDTO reviewRegisterDTO, MultipartFile[] images) {
        UserEntity userEntity = findUserByUsername(reviewRegisterDTO.getUser());
        ProductEntity productEntity = findProductById(reviewRegisterDTO.getProduct());

        if (reviewRegisterDTO.getImages() == null)
            return reviewConverter
                .reviewRegisterDtoToEntity(reviewRegisterDTO, userEntity, productEntity, null);

        // Todo: check if this must be isolated into other method or not.
        for (int i = 0; i < reviewRegisterDTO.getImages().length; i++) {
            if (fileService.hasValidImageExtension(reviewRegisterDTO.getImages()[i].getOriginalFilename(),(String) null))
                throw new FileHasNotValidExtensionException("Error: invalid image extension. Review not saved.");
        }

        return reviewConverter
            .reviewRegisterDtoToEntity(reviewRegisterDTO, userEntity, productEntity, reviewRegisterDTO.getImages());
    }

    private ProductEntity findProductById(String productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(String.format("Error: Product with id %s not found.", productId)));
    }

    private UserEntity findUserByUsername(String username) {
        return userRepository.findByUsernameAndActiveIsTrue(username)
                .orElseThrow(() -> new UserNotFoundException(String.format("Error: User with username %s not found.", username)));
    }

}