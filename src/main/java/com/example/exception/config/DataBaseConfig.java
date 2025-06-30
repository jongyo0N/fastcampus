package com.example.exception.config;

import com.example.exception.user.db.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseConfig {

    @Bean
    public final UserRepository userRepository;
}
