package com.example.provider.service;

import com.example.provider.dto.ProductRequest;
import com.example.provider.model.Product;
import com.example.provider.repository.ProductRepository;
import com.example.provider.response.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductResponse get(ProductRequest request) {
        ProductResponse response = new ProductResponse();
        if (request.username.charAt(0) == 'A') {
            response.product = repository.findFirstByProductStartsWith(request.username.charAt(0)).getProduct();
        } else {
            response.product = repository.findFirstByProductStartsWith('B').getProduct();
        }
        return response;
    }



    public ProductResponse add(String request){
        Product product = new Product();
        product.setProduct(request);
        return productModelToProductResponse(repository.save(product));
    }

    public ProductResponse productModelToProductResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.product = product.getProduct();
        return response;
    }
}
