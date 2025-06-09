package com.springudemy.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "I'm a funny football coach. Go practice your shot and trivela!!!";
    }
}
