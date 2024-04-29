package com.fatfrogdev.iemsbackend.services.impl;

import com.fatfrogdev.iemsbackend.domain.DTOS.ImageDTO;
import com.fatfrogdev.iemsbackend.domain.models.*;
import com.fatfrogdev.iemsbackend.domain.models.mongo.ImageMongoEntity;
import com.fatfrogdev.iemsbackend.repositories.IMongoImageEntityRepository;
import com.fatfrogdev.iemsbackend.repositories.IMongoImageRepository;
import com.fatfrogdev.iemsbackend.repositories.IReviewImageRepository;
import com.fatfrogdev.iemsbackend.repositories.IReviewRepository;
import com.fatfrogdev.iemsbackend.services.IImageService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class IImageServiceImpl implements IImageService {

    private final IMongoImageRepository imageRepository;

    private final IReviewImageRepository reviewImageRepository;

    private final IMongoImageEntityRepository mongoImageEntityRepository;

    private final IReviewRepository reviewRepository;

    @Override
    public ImageMongoEntity saveImage(ImageDTO imageDTO) throws IOException {
        Optional<ReviewEntity> reviewEntity = reviewRepository.findById(
                new ReviewId(new ClientEntity(imageDTO.getClientId()),
                        new ProductEntity(imageDTO.getProductId()),
                        imageDTO.getReviewNumber())
        );
        if (reviewEntity.isPresent()){

            ImageMongoEntity imageMongoEntity = new ImageMongoEntity(imageDTO.getImageTittle());

            Binary image = new Binary(imageDTO.getImage().getBytes());

            imageMongoEntity.setImage(image);

            String generatedUUID = UUID.randomUUID().toString();

            imageMongoEntity.setSqlId(generatedUUID);

            imageRepository.save(imageMongoEntity);

            MongoImageEntity mongoImage = mongoImageEntityRepository.save(
                    new MongoImageEntity((generatedUUID))
            );

            reviewImageRepository.save(new ReviewImageEntity(reviewEntity.get(), mongoImage));



            return imageMongoEntity;

        } throw new EntityNotFoundException("Image does not exist or was not found");
    }

    @Override
    public ImageMongoEntity findImageBySqlId(String imageId) throws IOException {
        Optional<ImageMongoEntity> imageMongoEntity = imageRepository.findBySqlId(imageId);
        if (imageMongoEntity.isPresent()){
            return imageMongoEntity.get();
        } throw new EntityNotFoundException("Image does not exist or was not found");
    }
}
