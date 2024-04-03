package com.fatfrogdev.iemsbackend.controllers;

import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewViewDTO;
import com.fatfrogdev.iemsbackend.services.IReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final IReviewService reviewService;

    @PostMapping("/save")
    public ResponseEntity<ReviewViewDTO> save(@RequestBody ReviewRegisterDTO reviewRegisterDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reviewService.save(reviewRegisterDTO));
    }
}
