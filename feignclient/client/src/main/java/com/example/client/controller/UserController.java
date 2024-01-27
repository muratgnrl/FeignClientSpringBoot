package com.example.client.controller;

import com.example.client.dto.UserRequest;
import com.example.client.response.UserResponse;
import com.example.client.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    ResponseEntity<UserResponse> add(@RequestBody UserRequest request){
        UserResponse response=userService.add(request);
        return ResponseEntity.ok(response);
    }
}
