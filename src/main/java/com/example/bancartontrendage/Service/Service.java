package com.example.bancartontrendage.Service;

import com.example.bancartontrendage.Dto.MemeDto;
import com.example.bancartontrendage.Dto.MemeQuestionDto;
import com.example.bancartontrendage.Dto.UserDto;
import com.example.bancartontrendage.Entity.MemeEntity;
import com.example.bancartontrendage.Entity.MemeQuestionEntity;
import com.example.bancartontrendage.Entity.UserEntity;
import com.example.bancartontrendage.Repository.MemeQuestionRepository;
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
    @Autowired
    private MemeQuestionRepository memeQuestionRepository;
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

    public List<MemeQuestionDto> findMemeChoice(Long memeId){
        List<MemeQuestionEntity>MemeQuestionEntityList = memeQuestionRepository.findByMemeId(memeId);
        if(MemeQuestionEntityList.isEmpty()){
            return null;
        } else {
            return MemeQuestionEntityList.stream().map(MemeQuestionEntity::toDto).toList();
        }
    }

}
