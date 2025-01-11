package com.example.bancartontrendage.Service;

import com.example.bancartontrendage.Dto.MemeDto;
import com.example.bancartontrendage.Dto.UserDto;
import com.example.bancartontrendage.Entity.MemeEntity;
import com.example.bancartontrendage.Entity.UserEntity;
import com.example.bancartontrendage.Repository.MemeRepository;
import com.example.bancartontrendage.Repository.UserRepository;
import com.example.bancartontrendage.RestController.MemeController;
import com.example.bancartontrendage.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private Util util = new Util();
    @Autowired
    private MemeRepository memeRepository;
    @Autowired
    private UserRepository userRepository;
    private MemeDto memeDto = new MemeDto();
    private UserDto userDto = new UserDto();
    private MemeEntity memeEntity = new MemeEntity();
    private UserEntity userEntity = new UserEntity();

    public List<MemeDto> findAllMemes() {
        List<MemeEntity> memeEntityList = memeRepository.findAll();
        if (memeEntityList.isEmpty()) // memeEntityList가 비어있을 경우
        {
            return null;
        } else {
            return memeEntityList.stream().map(MemeEntity::toDto).toList();
        }
    }

    public List<MemeDto> findYearMemes(Long year) {
        List<MemeEntity> memeEntityList =  memeRepository.findByYear(year);
        if(memeEntityList.isEmpty())// memeEntityList가 비어있을 경우
        {
            return null;
        } else {
            return memeEntityList.stream().map(MemeEntity::toDto).toList();
        }
    }


    public UserDto createInitialUser(String nickname) {
        // 새로운 UserDto 객체 생성
        UserDto userDto = new UserDto();

        // 기본 정보 설정
        userDto.setNickname(nickname);  // 입력받은 닉네임 설정
        userDto.setAge(0L);            // 나이 0으로 초기화
        userDto.setLevel("틀");         // 레벨 "틀"로 초기화

        // DB에 저장하고 저장된 결과를 DTO로 변환하여 반환
        return userRepository.save(userDto.toEntity()).toDto();
    }

    public UserDto createUser(UserDto userDto) {
        userDto.setLevel("틀");
        userDto.setAge(0L);
        try {
            userEntity = userRepository.save(userDto.toEntity());
            return userEntity.toDto();
        }catch (Exception e){
            return null;
        }
    }

}
