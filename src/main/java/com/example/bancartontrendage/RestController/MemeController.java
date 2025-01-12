package com.example.bancartontrendage.RestController;


import com.example.bancartontrendage.Dto.MemeDto;
import com.example.bancartontrendage.Dto.MemeQuestionDto;
import com.example.bancartontrendage.Service.Service;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/memes")
public class MemeController {
    @Autowired
    private Service service;

    @GetMapping
    public ResponseEntity<?> findAllMemes(){
        List<MemeDto> memeDtoList = service.findAllMemes();
        if(memeDtoList == null){
            return ResponseEntity.badRequest().body("밈 데이터를 찾지 못하였음..");
        } else {
            return ResponseEntity.ok(memeDtoList);
        }
    }

    @GetMapping("/{year}")
    public ResponseEntity<?> findYearMemes(@PathVariable Long year){
        List<MemeDto> memeDtoList = service.findYearMemes(year);
        if(memeDtoList == null){
            return ResponseEntity.badRequest().body("해당 연도의 밈 데이터를 찾지 못하였음..");
        } else {
            return ResponseEntity.ok(memeDtoList);
        }
    }

    @GetMapping("/choice/{memeId}")
    public ResponseEntity<?> findMemeChoice(@PathVariable Long memeId){
        List<MemeQuestionDto> memeQuestionDtoList = service.findMemeChoice(memeId);
        if(memeQuestionDtoList == null){
            return ResponseEntity.badRequest().body("해당 밈의 선택지를 찾지 못하였음..");
        } else {
            return ResponseEntity.ok(memeQuestionDtoList);
        }

    }




}
