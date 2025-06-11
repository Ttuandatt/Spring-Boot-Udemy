package com.springudemy.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "I'm a grumpy basketball coach. Go practice your jumping 1000 times!!!";
    }
}
