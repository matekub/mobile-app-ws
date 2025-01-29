package com.example.mobileappws.controller;

import com.example.mobileappws.model.request.UserDetailsRequestModel;
import com.example.mobileappws.model.response.UserRest;
import com.example.mobileappws.service.UserService;
import com.example.mobileappws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public String getUser(){
        return "getUser was called";
    }

    @PostMapping()
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnedUser = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnedUser);
        return returnedUser;
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
