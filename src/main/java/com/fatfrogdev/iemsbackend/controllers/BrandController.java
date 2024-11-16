package com.fatfrogdev.iemsbackend.controllers;


import com.fatfrogdev.iemsbackend.domain.models.BrandEntity;
import com.fatfrogdev.iemsbackend.services.IBrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/brands")
public class BrandController {

    private final IBrandService brandService;

    @PostMapping("/save")
    public ResponseEntity<BrandEntity> save(@RequestBody BrandEntity brandEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(brandService.save(brandEntity));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BrandEntity>> findAll(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.findAll(page, size));
    }

    @GetMapping("/{brandId}")
    public ResponseEntity<BrandEntity> findById(@PathVariable(value = "brandId") String brandId) {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.findById(brandId));
    }

    @GetMapping("")
    public ResponseEntity<List<BrandEntity>> findByParam(@RequestParam(value = "starts-with", required = false) String startsWith,
                                                         @RequestParam(value = "contains", required = false) String contains,
                                                         @RequestParam(value = "filial-owner", required = false) String filialOwner) {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.findByParam(startsWith, contains, filialOwner));
    }
}