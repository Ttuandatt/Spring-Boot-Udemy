package com.springudemy.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SwimmingCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "I'm a whatever swimming coach. Go....whatever";
    }
}
