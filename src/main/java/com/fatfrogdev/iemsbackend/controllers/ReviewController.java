package com.fatfrogdev.iemsbackend.controllers;

import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewRegisterDTO;
import com.fatfrogdev.iemsbackend.domain.DTOS.Review.ReviewViewDTO;
import com.fatfrogdev.iemsbackend.services.IReviewService;
import com.fatfrogdev.iemsbackend.services.IUploadFileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final IReviewService reviewService;

    private final IUploadFileService uploadFileService;

    @PostMapping("/save")
    public ResponseEntity<ReviewViewDTO> save(@RequestBody ReviewRegisterDTO reviewRegisterDTO,
                                              @RequestParam(value = "images", required = false) List<MultipartFile> images) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reviewService.save(reviewRegisterDTO, images));
    }

}
