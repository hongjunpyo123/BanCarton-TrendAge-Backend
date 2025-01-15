package com.example.bancartontrendage.Repository;

import com.example.bancartontrendage.Entity.MemeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemeRepository extends JpaRepository<MemeEntity, Long> {
    List<MemeEntity> findByYear(Long year);
    MemeEntity findTopByOrderByIdDesc();
}
