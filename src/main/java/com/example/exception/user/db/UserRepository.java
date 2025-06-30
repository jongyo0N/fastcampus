package com.example.exception.user.db;

import com.example.exception.db.SimpleDataRepository;
import com.example.exception.user.model.UserEntity;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserRepository extends SimpleDataRepository<UserEntity,Long> {

    private UserRepository userRepository;

    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    public List<UserEntity> findAllScore(int score){
        this.findAll().stream()
                .filter(
                        it->{
                            return it.getScore()>=score;
                        }
                ).collect(Collectors.toList());
    }
}
