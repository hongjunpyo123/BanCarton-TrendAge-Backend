package com.example.bancartontrendage.Service;

import com.example.bancartontrendage.Dto.MemeDto;
import com.example.bancartontrendage.Dto.UserDto;
import com.example.bancartontrendage.Repository.MemeRepository;
import com.example.bancartontrendage.Repository.UserRepository;
import com.example.bancartontrendage.RestController.MemeController;
import com.example.bancartontrendage.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    private Util util = new Util();
    @Autowired
    private MemeRepository memeRepository;
    @Autowired
    private UserRepository userRepository;
    private MemeDto memeDto = new MemeDto();
    private UserDto userDto = new UserDto();


}
