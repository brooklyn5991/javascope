package com.Gifttech.Springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{


    public TrackCoach() {
        System.out.println("constructor " + getClass().getSimpleName());
    }
    @Override
    public String getCoach() {
        return "practice track";
    }
}
