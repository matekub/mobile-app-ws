package com.example.mobileappws.controller;

import com.example.mobileappws.model.request.UserDetailsRequestModel;
import com.example.mobileappws.model.response.UserRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping()
    public String getUser(){
        return "getUser was called";
    }

    @PostMapping()
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
        return null;
    }

    @PutMapping()
    public String updateUser(){
        return "updateUser was called";
    }

    @DeleteMapping()
    public String deleteUser(){
        return "deleteUser was called";
    }
}
