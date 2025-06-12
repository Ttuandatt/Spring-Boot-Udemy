package com.springudemy.springcoredemo.common;

public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "I'm a tennis coach hehe";
    }
}
