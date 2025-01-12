package com.example.bancartontrendage.Entity;

import com.example.bancartontrendage.Dto.MemeDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "meme")
public class MemeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 255)
    private String content;

    @Column
    private Long year;

    @Column(length = 255)
    private String explanation;

    @Column(length = 255)
    private String question;

    @Column
    private Long answer;

    public MemeDto toDto(){ //Entity객체를 dto객체로 변환
        MemeDto memeDto = new MemeDto();
        memeDto.setId(this.id);
        memeDto.setContent(this.content);
        memeDto.setYear(this.year);
        memeDto.setExplanation(this.explanation);
        memeDto.setQuestion(this.question);
        memeDto.setAnswer(this.answer);

        return memeDto;
    }
}
