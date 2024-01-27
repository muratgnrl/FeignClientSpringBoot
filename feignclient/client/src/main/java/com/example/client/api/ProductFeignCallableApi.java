package com.example.client.api;

import com.example.client.dto.ProductRequest;
import com.example.client.response.ProductResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface  ProductFeignCallableApi {

    @PostMapping("/provider/product/get")
    ProductResponse get(@RequestBody ProductRequest request);
}
