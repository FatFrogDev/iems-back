package com.fatfrogdev.iemsbackend.controllers;

import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewViewDTO;
import com.fatfrogdev.iemsbackend.services.IReviewService;
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

    private final Logger LOGGER = LoggerFactory.getLogger(ReviewController.class);

    @PostMapping(value = "/save", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ReviewViewDTO> saveWithoutImages(@RequestBody ReviewRegisterDTO reviewRegisterDTO) {
        LOGGER.info("Review saved.");
        return ResponseEntity.status(HttpStatus.OK)
                .body(reviewService.saveWithoutImages(reviewRegisterDTO, null));
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewViewDTO> findReviewById(@PathVariable String reviewId){
        LOGGER.info(String.format("Searching for review with id: %s ", reviewId));
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.findReviewById(reviewId));
    }

    @PostMapping(value = "/images/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> saveReviewImages(@RequestParam("r") String reviewId, @RequestParam("images") MultipartFile[] images) throws IOException {
        LOGGER.info(String.format("%d images uploaded to review with id: %s", images.length, reviewId));
        reviewService.saveReviewImages(reviewId, images);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable String reviewId){
        reviewService.deleteReview(reviewId);
        LOGGER.warn(String.format("Review with id: %s deleted", reviewId));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{reviewId}/images/{imageId}")
    public ResponseEntity<Void> deleteReviewImage(@PathVariable String imageId, @PathVariable String reviewId){
        reviewService.deleteReviewImages(reviewId, imageId);
        LOGGER.warn(String.format("Image %s deleted", imageId));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}