package com.springudemy.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach{
    public BasketballCoach() {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    // define post construct method
    @PostConstruct
    public void postConstruct() {
        System.out.println("In postConstruct(): " + getClass().getSimpleName());
        System.out.println("The line above is created right after the BasketballCoach instance is initialized");
    }

    // define pre destroy method
    @PreDestroy
    public void preDestroy() {
        System.out.println("The line below is created right before the BasketballCoach instance is destroyed");
        System.out.println("In preDestroy(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "I'm a grumpy basketball coach. Go practice your jumping 1000 times!!!";
    }
}
