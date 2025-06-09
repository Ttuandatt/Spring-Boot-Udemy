package com.springudemy.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "I'm a whatever swimming coach. Go....whatever";
    }
}
