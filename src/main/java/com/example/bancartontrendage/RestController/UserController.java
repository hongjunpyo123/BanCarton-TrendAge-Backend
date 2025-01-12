package com.example.bancartontrendage.RestController;

import com.example.bancartontrendage.Dto.UserDto;
import com.example.bancartontrendage.Service.Service;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private Service service;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto, HttpSession session) {
        UserDto userDto1 = service.createUser(userDto, session);
        if(userDto1 == null){
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(userDto1);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) { //nicknamae과 score, id 받아옴
        System.out.println("id :" + userDto.getId());
        System.out.println("nickname :" + userDto.getNickname());
        System.out.println("score :" + userDto.getScore());
        UserDto userDto1 = service.updateUser(userDto);
        if(userDto1 == null){
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(userDto1);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllUsers() {
        List<UserDto> userDtoList = service.findAllUsers();
        if(userDtoList == null){
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(userDtoList);
        }
    }


}
