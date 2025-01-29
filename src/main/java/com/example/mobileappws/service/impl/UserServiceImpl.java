package com.example.mobileappws.service.impl;

import com.example.mobileappws.io.entity.UserEntity;
import com.example.mobileappws.repository.UserRepository;
import com.example.mobileappws.service.UserService;
import com.example.mobileappws.shared.Utils;
import com.example.mobileappws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Utils utils;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto createUser(UserDto userDto) {

        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new RuntimeException("Record already exists");
        }

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userEntity.setUserId(utils.generateRandomString(30));

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto newUserDto = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, newUserDto);
        return newUserDto;
    }
}
