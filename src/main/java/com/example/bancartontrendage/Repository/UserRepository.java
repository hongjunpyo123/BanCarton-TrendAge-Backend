package com.example.bancartontrendage.Repository;

import com.example.bancartontrendage.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllByOrderByAgeAsc(); //age값을 기준으로 오름차순 정렬 반환
}
