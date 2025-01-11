package com.example.bancartontrendage.Entity;

import com.example.bancartontrendage.Dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 255)
    private String nickname;

    @Column
    private Long age;

    @Column(length = 255)
    private String level;

    public UserDto toDto(){ //Entity객체를 dto객체로 변환
        UserDto userDto = new UserDto();
        userDto.setId(this.id);
        userDto.setNickname(this.nickname);
        userDto.setAge(this.age);
        userDto.setLevel(this.level);
        return userDto;
    }
}
