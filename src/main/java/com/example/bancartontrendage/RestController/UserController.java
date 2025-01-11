package com.example.bancartontrendage.RestController;

// 필요한 클래스들을 import합니다.
import com.example.bancartontrendage.Dto.UserDto;
import com.example.bancartontrendage.Entity.UserEntity;
import com.example.bancartontrendage.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {

    // UserService를 자동으로 주입받습니다.
    @Autowired
    private UserService userService;

    // "/create" 엔드포인트에 대한 GET 요청을 처리합니다.
    @GetMapping("/create")
    public UserDto createUser(@RequestParam String nickname) {
        // UserDto 객체를 생성하고 닉네임을 설정합니다.
        UserDto userDto = new UserDto();
        userDto.setNickname(nickname);

        // UserService를 사용하여 UserEntity 객체를 생성합니다.
        UserEntity userEntity = userService.createUser(userDto);

        // 응답으로 반환할 UserDto 객체를 생성하고, UserEntity의 데이터를 설정합니다.
        
        userDto.setId(userEntity.getId());
        userDto.setNickname(userEntity.getNickname());
        userDto.setAge(userEntity.getAge());
        userDto.setLevel(userEntity.getLevel());

        // UserDto 객체를 반환합니다.
        return userDto;
    }
}