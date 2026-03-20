package com.Gifttech.Springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("constructor " + getClass().getSimpleName());
    }
    @Override
    public String getCoach() {
        return "play tennis";
    }
}
