package com.example.bancartontrendage.Entity;

import com.example.bancartontrendage.Dto.MemeQuestionDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "memeQuestion")
public class MemeQuestionEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long memeId;

    @Column(length = 255)
    private String choice;

    @Column(length = 255)
    private String answer;


    public MemeQuestionDto toDto(){
        MemeQuestionDto memeQuestionDto = new MemeQuestionDto();
        memeQuestionDto.setId(this.id);
        memeQuestionDto.setMemeId(this.memeId);
        memeQuestionDto.setChoice(this.choice);
        memeQuestionDto.setAnswer(this.answer);
        return memeQuestionDto;
    }

}
