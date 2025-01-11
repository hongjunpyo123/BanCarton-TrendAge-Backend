package com.example.bancartontrendage.Repository;

import com.example.bancartontrendage.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
