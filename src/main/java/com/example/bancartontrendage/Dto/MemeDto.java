package com.example.bancartontrendage.Dto;

import com.example.bancartontrendage.Entity.MemeEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemeDto {
    private Long id;
    private String content;
    private Long year;
    private String explanation;


    public MemeEntity toEntity(){ //dto객체를 entity객체로 변환
        MemeEntity memeEntity = new MemeEntity();
        memeEntity.setContent(this.content);
        memeEntity.setYear(this.year);
        memeEntity.setExplanation(this.explanation);
        return memeEntity;
    }
}
