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
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<MemeDto> find20Memes() { //연도별로 5개씩 랜덤하게 15개 반환
        List<MemeEntity> memeEntityList = new ArrayList<MemeEntity>();

        List<MemeEntity> memeEntityList00 = memeRepository.findByYear(2000L); //2000년도 밈 전부 조회
        List<MemeEntity> memeEntityList10 = memeRepository.findByYear(2010L); //2010년도 밈 전부 조회
        List<MemeEntity> memeEntityList20 = memeRepository.findByYear(2020L); //2020년도 밈 전부 조회

        Collections.shuffle(memeEntityList00);
        Collections.shuffle(memeEntityList10);
        Collections.shuffle(memeEntityList20);


        memeEntityList.addAll(memeEntityList00.subList(0, 5));
        memeEntityList.addAll(memeEntityList10.subList(0, 5));
        memeEntityList.addAll(memeEntityList20.subList(0, 10));

        return memeEntityList.stream().map(MemeEntity::toDto).toList();
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

    public UserDto createUser(UserDto userDto, HttpSession session) {
        userDto.setLevel("틀");
        userDto.setAge(40L);
            userDto.setId(null);
            userEntity = userRepository.save(userDto.toEntity());
            session.setAttribute("userId", userEntity.getId());
            return userEntity.toDto();

    }

    public List<MemeQuestionDto> findMemeChoice(Long memeId){
        List<MemeQuestionEntity>MemeQuestionEntityList = memeQuestionRepository.findByMemeId(memeId);
        if(MemeQuestionEntityList.isEmpty()){
            return null;
        } else {
            return MemeQuestionEntityList.stream().map(MemeQuestionEntity::toDto).toList();
        }
    }

    public UserDto updateUser(UserDto userDto) {
        //잼민이 -> 급식 -> MZ  -> 틀
        //잼민이 0살~13살
        //급식  14살~19살
        //mz   20살~29살
        //틀   30살~
        System.out.println(userDto.getId());
        userDto.setAge(40L - (userDto.getScore()*2));
        if(userDto.getAge() == 0){ //잼민이
            userDto.setLevel("잼민이");
        } else if (1 <= userDto.getAge() && userDto.getAge() <= 6){ //급식
            userDto.setLevel("급식");
        } else if (7 <= userDto.getAge() && userDto.getAge() <= 16){ //MZ
            userDto.setLevel("MZ");
        } else { //틀
            userDto.setLevel("틀");
        }
        try {
            userEntity = userRepository.save(userDto.toEntity());
            return userEntity.toDto();
        } catch (Exception e){
            return null;
        }
    }

    public List<UserDto> findAllUsers(){
        List<UserEntity> userEntityList = userRepository.findAllByOrderByAgeAsc();
        if(userEntityList.isEmpty()){
            return null;
        } else {
            return userEntityList.stream().map(UserEntity::toDto).toList();
        }
    }

    public void createMemeAdmin(MemeDto memeDto, MemeQuestionDto memeQuestionDto1,
                                MemeQuestionDto memeQuestionDto2, MemeQuestionDto memeQuestionDto3) {
        memeEntity = memeRepository.save(memeDto.toEntity());

       memeQuestionDto1.setMemeId(memeEntity.getId());
       memeQuestionDto2.setMemeId(memeEntity.getId());
       memeQuestionDto3.setMemeId(memeEntity.getId());

       memeQuestionDto1.setAnswer("false");
       memeQuestionDto2.setAnswer("false");
       memeQuestionDto3.setAnswer("false");

       if(memeEntity.getAnswer() == 1){
           memeQuestionDto1.setAnswer("true");
       } else if (memeEntity.getAnswer() == 2){
           memeQuestionDto2.setAnswer("true");
       } else if (memeEntity.getAnswer() == 3){
           memeQuestionDto3.setAnswer("true");
       }

       memeQuestionRepository.save(memeQuestionDto1.toEntity());
       memeQuestionRepository.save(memeQuestionDto2.toEntity());
       memeQuestionRepository.save(memeQuestionDto3.toEntity());
    }

}
