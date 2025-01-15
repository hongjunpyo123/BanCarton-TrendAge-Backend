package com.example.bancartontrendage.Repository;

import com.example.bancartontrendage.Entity.MemeQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemeQuestionRepository extends JpaRepository<MemeQuestionEntity, Long> {
    List<MemeQuestionEntity> findByMemeId(Long memeId);
    MemeQuestionEntity findTopByOrderByIdDesc();
}
