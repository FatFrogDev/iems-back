package com.fatfrogdev.iemsbackend.controllers;

import com.fatfrogdev.iemsbackend.services.IFileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/files")
public class FileController {

    private final IFileService fileService;

    @GetMapping(value = "/images/{fileId}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<byte[]> findImageById(@PathVariable String fileId){
        return ResponseEntity.status(HttpStatus.OK).body(fileService.findImageById(fileId));
    }

    @GetMapping(value = "/documents/{fileId}", produces = {MediaType.APPLICATION_PDF_VALUE})
    public ResponseEntity<byte[]> findDocumentById(@PathVariable String fileId){
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/images/{fileId}")
    public ResponseEntity<Void> deleteImageById(@PathVariable String fileId){
        fileService.deleteImageById(fileId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}