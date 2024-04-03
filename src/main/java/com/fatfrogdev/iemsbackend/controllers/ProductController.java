package com.fatfrogdev.iemsbackend.controllers;

import com.fatfrogdev.iemsbackend.domain.DTOS.Product.ProductDTO;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;
import com.fatfrogdev.iemsbackend.services.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO){
        System.out.println("ProductDTO: " + productDTO.toString() );
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productDTO));
    }

    @GetMapping("/find/{productId}")
    public ResponseEntity<ProductEntity> findById(@PathVariable String productId){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.findById(productId));
    }

    @GetMapping("/find2")
    public ResponseEntity<List<ProductEntity>> findByNameStartingWith(@RequestParam("startsWith") String prefix){
        return ResponseEntity.ok(productService.findByNameStartingWith(prefix));
    }

    @GetMapping("/find/name/{containing}")
    public ResponseEntity<List<ProductEntity>> findByNameContaining(@PathVariable String containing){
        return ResponseEntity.ok(productService.findByNameContaining(containing));
    }
}
