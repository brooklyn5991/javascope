package com.Gifttech.Springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {




    @Override
    public String getCoach() {
        return "Java programmer Oke Okorefe";
    }

}