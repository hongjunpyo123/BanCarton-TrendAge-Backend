package com.example.bancartontrendage.Dto;

import com.example.bancartontrendage.Entity.MemeQuestionEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemeQuestionDto {
    private Long id;
    private Long memeId;
    private String choice;
    private String url;

    public MemeQuestionEntity toEntity(){
        MemeQuestionEntity memeQuestionEntity = new MemeQuestionEntity();
        memeQuestionEntity.setId(this.id);
        memeQuestionEntity.setMemeId(this.memeId);
        memeQuestionEntity.setChoice(this.choice);
        memeQuestionEntity.setUrl(this.url);
        return memeQuestionEntity;
    }
}
