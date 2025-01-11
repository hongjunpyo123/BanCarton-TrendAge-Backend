package com.example.bancartontrendage.Dto;

import com.example.bancartontrendage.Entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String nickname;
    private Long age;
    private String level;

    public UserEntity toEntity(){ //dto객체를 entity객체로 변환ia
        UserEntity userEntity = new UserEntity();
        userEntity.setNickname(this.nickname);
        userEntity.setAge(this.age);
        userEntity.setLevel(this.level);
        return userEntity;
    }
}
