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

    @GetMapping("") // brands?id=...
    public ResponseEntity<BrandEntity> findById(@RequestParam("id") String brandId) {
        return ResponseEntity.ok(brandService.findById(brandId));
    }

    @GetMapping("/query")
    public ResponseEntity<List<BrandEntity>> findByBrandIdStartsWith(@RequestParam("startsWith") String prefix) {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.findByBrandIdStartsWith(prefix));
    }

    @GetMapping("/query2")
    public ResponseEntity<List<BrandEntity>> findByBrandIdContaining(@RequestParam("containing") String containing) {
        return ResponseEntity.status(HttpStatus.OK).body(brandService.findByBrandIdContaining(containing));
    }
}
