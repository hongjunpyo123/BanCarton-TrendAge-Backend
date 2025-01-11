package com.example.bancartontrendage.Service;

import com.example.bancartontrendage.Dto.UserDto;
import com.example.bancartontrendage.Entity.UserEntity;
import com.example.bancartontrendage.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserDto userDto) {
        UserEntity userEntity = userDto.toEntity();
        userEntity.setAge(0L); // 기본값 설정
        userEntity.setLevel("기본"); // 기본값 설정
        return userRepository.save(userEntity);
    }
}