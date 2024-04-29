package com.fatfrogdev.iemsbackend.services;

import com.fatfrogdev.iemsbackend.domain.DTOS.ImageDTO;
import com.fatfrogdev.iemsbackend.domain.models.mongo.ImageMongoEntity;

import java.io.IOException;

public interface IImageService {

    ImageMongoEntity saveImage(ImageDTO imageDTO) throws IOException;

    ImageMongoEntity findImageBySqlId(String imageId) throws IOException;
}
