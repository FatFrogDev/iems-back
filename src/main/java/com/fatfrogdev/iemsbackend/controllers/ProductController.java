package com.fatfrogdev.iemsbackend.controllers;

import com.fatfrogdev.iemsbackend.domain.DTOS.Product.ProductDTO;
import com.fatfrogdev.iemsbackend.domain.models.CategoryEntity;
import com.fatfrogdev.iemsbackend.domain.models.ProductEntity;
import com.fatfrogdev.iemsbackend.services.ICategoryService;
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

    private final ICategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductEntity>> findAllProducts(@RequestParam(value = "page", required = false) Integer page,
                                                               @RequestParam(value = "size", required = false) Integer size){
        return ResponseEntity.ok(productService.findAll(page, size));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductEntity> findProductById(@PathVariable String productId){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.findById(productId));
    }

    @GetMapping("") // products?id=... TODO: Redirect to the proper function according to the parameters given in the request.
    public ResponseEntity<List<ProductEntity>> findProductByNameStartingWith(@RequestParam("startsWith") String prefix, @RequestParam String containing){
        return ResponseEntity.ok(null);
    }

    // Categories

    @PostMapping("/categories/save")
    public ResponseEntity<CategoryEntity> saveCategory(@RequestBody CategoryEntity categoryEntity){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.save(categoryEntity));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> findAllCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
    }

    @GetMapping("/categories/{categoryName}")
    public ResponseEntity<CategoryEntity> findCategoryByName(@PathVariable String categoryName){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findByName(categoryName));
    }
}
