package com.springudemy.springcoredemo.rest;

import com.springudemy.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach1;
    private Coach coach2;

    @Autowired
    public DemoController(@Qualifier("basketballCoach") Coach coach1,
                          @Qualifier("basketballCoach") Coach coach2) {
        System.out.println("In Constructor: " + getClass().getSimpleName());
        this.coach1 = coach1;
        this.coach2 = coach2;

    }

    @GetMapping("/check")
    public String check() {
        String message = "";
        if(coach1.equals(coach2)) {
            message = "coach1 & coach2 are referencing the same Singleton scope bean which is an instance of basketballCoach";
        }else{
            message = "coach1 & coach2 are two different instances";
        }

        return message;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return coach1.getDailyWorkout();
    }
}
