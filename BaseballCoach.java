package com.Gifttech.Springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach{

    public String coachName = "Oke";

    public void setCoachName(String name) {
        this.coachName = name;
    }

    public String getCoachName() {
        return this.coachName;
    }

    public BaseballCoach() {
        System.out.println("constructor " + getClass().getSimpleName());
    }
    @Override
    public String getCoach() {
        return "play baseball";
    }
}
