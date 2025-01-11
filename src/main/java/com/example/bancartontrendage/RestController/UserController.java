package com.example.bancartontrendage.RestController;
import com.example.bancartontrendage.Dto.UserDto;
import com.example.bancartontrendage.Entity.UserEntity;
import com.example.bancartontrendage.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public UserDto createUser(@RequestParam String nickname) {
        UserDto userDto = new UserDto();
        userDto.setNickname(nickname);
        UserEntity userEntity = userService.createUser(userDto);
        UserDto responseDto = new UserDto();
        responseDto.setId(userEntity.getId());
        responseDto.setNickname(userEntity.getNickname());
        responseDto.setAge(userEntity.getAge());
        responseDto.setLevel(userEntity.getLevel());
        return responseDto;
    }
}