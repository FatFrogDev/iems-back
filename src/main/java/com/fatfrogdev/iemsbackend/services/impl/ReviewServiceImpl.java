package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.converters.ReviewConverter;
import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewViewDTO;
import com.fatfrogdev.iemsbackend.domain.models.*;
import com.fatfrogdev.iemsbackend.repositories.IClientRepository;
import com.fatfrogdev.iemsbackend.repositories.IProductRepository;
import com.fatfrogdev.iemsbackend.repositories.IReviewRepository;
import com.fatfrogdev.iemsbackend.services.IFileService;
import com.fatfrogdev.iemsbackend.services.IReviewService;
import jakarta.persistence.EntityNotFoundException;
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

    private final IClientRepository clientRepository;

    private IFileService fileService;

    @Override
    public ReviewViewDTO saveWithoutImages(ReviewRegisterDTO reviewRegisterDTO, MultipartFile[] images) {
        ReviewEntity reviewEntity = buildEntity(reviewRegisterDTO, images);
        if (reviewEntity!=null)
            return reviewConverter.entityToViewDto(
                    reviewRepository.save(reviewEntity)
            );
        else throw new RuntimeException("Error: client or product not found.");
    }

    @Override
    public void saveReviewImages(String clientId, String productId, MultipartFile[] images) throws IOException {
        ReviewEntity reviewEntity = reviewRepository.findById(new ReviewId(new ClientEntity(clientId), new ProductEntity(productId)))
                .orElseThrow(() -> new RuntimeException("Error: review not found."));

        Set<FileEntity> reviewImages = new HashSet<>();

        for (MultipartFile image : images) {
            if (fileService.hasValidImageExtension(image.getOriginalFilename(), (String[]) null))
                throw new RuntimeException("Error: invalid image extension. Review not saved.");

            if (!fileService.imageHasValidSize(image))
                throw new RuntimeException(String.format("Error: Image %s size exceeds the limit of 10MB. Review not saved.", image.getOriginalFilename()));

            reviewImages.add(
                    new FileEntity(image.getOriginalFilename(), image.getContentType(), image.getBytes())
            );
        }       reviewEntity.setImages(reviewImages);
                reviewRepository.save(reviewEntity);
    }


    @Override
    public void deleteReview(String clientId, String productId) {
        boolean clientExists = clientRepository.existsById(clientId);
        if (!clientExists)
            throw new EntityNotFoundException("Client or product not found.");

        boolean productExists = productRepository.existsById(productId);
        if (!productExists)
            throw new EntityNotFoundException("Client or product not found.");

        ReviewId reviewId = ReviewId.builder()
                .client(new ClientEntity(clientId))
                .product(new ProductEntity(productId)).build();

        boolean exists = reviewRepository.existsById(reviewId);
        if (!exists)
            throw new EntityNotFoundException("Review not found.");
        else
            reviewRepository.deleteById(reviewId);
    }

    @Transactional
    @Override
    public void deleteReviewImages(String clientId, String productId, String imageId) {
        ReviewEntity reviewEntity = reviewRepository.findById(new ReviewId(new ClientEntity(clientId), new ProductEntity(productId)))
                .orElseThrow(EntityNotFoundException::new);

        FileEntity image = reviewEntity.getImages().stream()
                .filter(file -> file.getFileId().equals(imageId))
                .findFirst()
                .orElseThrow(EntityNotFoundException::new);

        reviewEntity.getImages().remove(image);
        reviewRepository.save(reviewEntity);

        fileService.deleteImageById(imageId);
    }

    private ReviewEntity buildEntity(ReviewRegisterDTO reviewRegisterDTO, MultipartFile[] images) {
        Optional<ClientEntity> client = clientRepository.findByUserUsernameAndUserDeletedIsFalse(reviewRegisterDTO.getUserId());
        Optional<ProductEntity> product = productRepository.findById(reviewRegisterDTO.getProductId());

        if(client.isPresent() && product.isPresent()){
            if (reviewRegisterDTO.getImages() == null){
                return reviewConverter
                        .reviewRegisterDtoToEntity(reviewRegisterDTO,product.get(), client.get(), null);
            }

            for (int i = 0; i < reviewRegisterDTO.getImages().length; i++) {
                if (fileService.hasValidImageExtension(reviewRegisterDTO.getImages()[i].getOriginalFilename(), "jpg", "jpeg", "png", "webp"))
                    throw new RuntimeException("Error: invalid image extension. Review not saved.");
            }

            return reviewConverter
                    .reviewRegisterDtoToEntity(reviewRegisterDTO,product.get(), client.get(), reviewRegisterDTO.getImages());
        }
        return null;
    }

}