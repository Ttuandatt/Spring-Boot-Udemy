package com.springudemy.springcoredemo.rest;

import com.springudemy.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach1;

    @Autowired
    public DemoController(@Qualifier("basketballCoach") Coach coach1) {
        System.out.println("In Constructor: " + getClass().getSimpleName());
        this.coach1 = coach1;

    }



    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return coach1.getDailyWorkout();
    }
}
