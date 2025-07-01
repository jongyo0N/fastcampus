package com.example.exception.user.db;

import com.example.exception.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

    public List<UserEntity> findAllScoreGreaterThanEqual(Integer score);


    @Query(
            value = "select * from user as u where u.score>= :min AND u.score <= :max",
            nativeQuery = true)
    List<UserEntity> score(@Param(value = "max")int max,@Param(value = "min") int min);
}