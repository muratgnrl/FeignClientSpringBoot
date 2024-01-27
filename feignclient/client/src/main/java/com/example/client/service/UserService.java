package com.example.client.service;

import com.example.client.api.ProductFeignCallableApi;
import com.example.client.dto.ProductRequest;
import com.example.client.dto.UserRequest;
import com.example.client.model.User;
import com.example.client.repository.UserRepository;
import com.example.client.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProductFeignCallableApi feignCallableApi;

    public UserService(UserRepository userRepository, ProductFeignCallableApi feignCallableApi) {
        this.userRepository = userRepository;
        this.feignCallableApi = feignCallableApi;

    }

    public UserResponse add(UserRequest request) {
        User user=new User();
        user.setUsername(request.username);
        ProductRequest productRequest=new ProductRequest();
        productRequest.username= request.username;
        user.setProduct(feignCallableApi.get(productRequest).product);
        return userModelToUserResponseDto(userRepository.save(user));
    }

    public UserResponse userModelToUserResponseDto(User user){
        UserResponse response = new UserResponse();
        response.username = user.getUsername();
        response.product = user.getProduct();
        return response;
    }
}
