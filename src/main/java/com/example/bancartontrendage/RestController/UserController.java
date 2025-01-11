package com.example.bancartontrendage.RestController;

import com.example.bancartontrendage.Dto.UserDto;
import com.example.bancartontrendage.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private Service service;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(service.createUser(userDto));
    }

}
