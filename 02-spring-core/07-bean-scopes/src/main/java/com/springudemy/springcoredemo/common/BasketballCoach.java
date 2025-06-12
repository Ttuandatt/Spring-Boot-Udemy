package com.springudemy.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // this means Spring will create a new instance of this class everytime we do dependency injection
public class BasketballCoach implements Coach{
    public BasketballCoach() {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "I'm a grumpy basketball coach. Go practice your jumping 1000 times!!!";
    }
}
