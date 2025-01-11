package com.example.bancartontrendage.Entity;

import com.example.bancartontrendage.Dto.MemeDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MemeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 255)
    private String content;

    @Column
    private Long year;

    public MemeDto toDto(){ //Entity객체를 dto객체로 변환
        MemeDto memeDto = new MemeDto();
        memeDto.setId(this.id);
        memeDto.setContent(this.content);
        memeDto.setYear(this.year);
        return memeDto;
    }
}
