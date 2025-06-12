package com.springudemy.springcoredemo.config;

import com.springudemy.springcoredemo.common.Coach;
import com.springudemy.springcoredemo.common.TennisCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquamanTeacher")
    public Coach tennisCoach(){
        return new TennisCoach();
    }

}
