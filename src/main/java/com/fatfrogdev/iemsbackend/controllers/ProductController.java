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

    @GetMapping("/all")
    public ResponseEntity<List<ProductEntity>> findAl(){ // TODO: Add findAll function to the service with pagination.
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductEntity> findById(@PathVariable String productId){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.findById(productId));
    }

    @GetMapping("") // products?id=... TODO: Redirect to the proper function according to the parameters given in the request.
    public ResponseEntity<List<ProductEntity>> findByNameStartingWith(@RequestParam("startsWith") String prefix, @RequestParam String containing){
        return ResponseEntity.ok(null);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productDTO));
    }
}
