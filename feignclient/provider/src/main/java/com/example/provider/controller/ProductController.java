package com.example.provider.controller;

import com.example.provider.dto.ProductRequest;
import com.example.provider.response.ProductResponse;
import com.example.provider.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provider/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }


    @GetMapping("/get")
    public ResponseEntity<ProductResponse> get (@RequestBody ProductRequest request){
        ProductResponse response=service.get(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/add/{product}")
    public ResponseEntity<ProductResponse> add(@PathVariable(name="product") String request){
        ProductResponse response = service.add(request);
        return ResponseEntity.ok(response);
    }
}
