package com.fatfrogdev.iemsbackend.controllers;

import com.fatfrogdev.iemsbackend.domain.DTOS.ImageDTO;
import com.fatfrogdev.iemsbackend.domain.models.mongo.ImageMongoEntity;
import com.fatfrogdev.iemsbackend.services.IImageService;
import lombok.AllArgsConstructor;
import org.bson.types.Binary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/images")
public class ImageController {

    private final IImageService imageService;

    @PostMapping("/save")
    public ResponseEntity<ImageMongoEntity> saveImage(ImageDTO imageDTO) {
        try {
            return ResponseEntity.ok(imageService.saveImage(imageDTO));
        } catch (IOException e) {
            throw  new RuntimeException("Error saving image");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageMongoEntity> findImageBySqlId(@PathVariable("id") String imageId) {
        try {
            return ResponseEntity.ok(imageService.findImageBySqlId(imageId));
        } catch (IOException e) {
            throw  new RuntimeException("Error finding image");
        }
    }

    @GetMapping(path = "/{id}/image", produces =  MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> findImageContentBySqlId(@PathVariable("id") String imageId) {
        try {
            Binary image = imageService.findImageBySqlId(imageId).getImage();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("image", "image.png");

            return ResponseEntity.ok().headers(headers).body(image.getData());
        } catch (IOException e) {
            throw  new RuntimeException("Error finding image");
        }
    }
}
