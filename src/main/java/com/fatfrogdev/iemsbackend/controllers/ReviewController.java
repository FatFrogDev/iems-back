package com.fatfrogdev.iemsbackend.controllers;

import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewViewDTO;
import com.fatfrogdev.iemsbackend.services.IReviewService;
import com.fatfrogdev.iemsbackend.services.IFileService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@AllArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final IReviewService reviewService;

    private final IFileService uploadFileService;

    private final Logger LOGGER = LoggerFactory.getLogger(ReviewController.class);

    @PostMapping(value = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReviewViewDTO> saveWithoutImages(@RequestBody ReviewRegisterDTO reviewRegisterDTO) {
        LOGGER.info("Review saved");
        return ResponseEntity.status(HttpStatus.OK)
                .body(reviewService.saveWithoutImages(reviewRegisterDTO, null));

    }

    @PostMapping(value = "/images/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> saveReviewImages(@RequestParam("c") String clientId, @RequestParam("p") String productId, @RequestParam("images") MultipartFile[] images) throws IOException {
        LOGGER.info("{} images uploaded.", images.length);
        LOGGER.info(String.format("Review:{Client: %s, Product: %s}", clientId, productId));
        reviewService.saveReviewImages(clientId, productId, images);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteReview(@RequestParam("c") String clientId, @RequestParam("p") String productId){
        reviewService.deleteReview(clientId, productId);
        LOGGER.info(String.format("Review deleted: {Client: %s, Product: %s}", clientId, productId));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/images/{imageId}")
    public ResponseEntity<Void> deleteReviewImage(@PathVariable String imageId, @RequestParam("c") String clientId, @RequestParam("p") String productId){
        reviewService.deleteReviewImages(clientId, productId, imageId);
        LOGGER.info(String.format("Image %s deleted", imageId));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
