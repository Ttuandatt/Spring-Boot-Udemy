package com.springudemy.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BasketballCoach implements Coach{
    public BasketballCoach() {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "I'm a grumpy basketball coach. Go practice your jumping 1000 times!!!";
    }
}
