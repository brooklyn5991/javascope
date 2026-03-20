package com.Gifttech.Springcoredemo.rest;

import com.Gifttech.Springcoredemo.common.BaseballCoach;
import com.Gifttech.Springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;


    public DemoController(
            @Qualifier("baseballCoach") Coach theCoach,
            @Qualifier("baseballCoach") Coach theAnotherCoach) {

        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/test-baseball")
    public String testBaseball() {

        BaseballCoach c1 = (BaseballCoach) myCoach;
        BaseballCoach c2 = (BaseballCoach) anotherCoach;

        c1.setCoachName("Oke Okorefe");


        return "Coach 1 Name: " + c1.getCoachName() +
                "<br>Coach 2 Name: " + c2.getCoachName();
    }
}

//@RestController
//// CHANGE THIS FROM 'interface' TO 'class'
//public class DemoController {
//
//
//    private Coach theCoach;
//    private Coach hisCoach;
//
//    @Autowired
//    public DemoController(@Qualifier("baseballCoach") Coach myCoach,
//                           @Qualifier("baseballCoach") Coach herCoach) {
//        theCoach = myCoach;
//        hisCoach = herCoach;
//    }
//
//    @GetMapping("/school")
//    public String newCoach() {
//        // 1. Cast to CricketCoach to access the unique methods
//
////        return theCoach.getCoach();
//    }
//
////    @GetMapping("/check")
////    public String check() {
////        return "compare " + (theCoach == hisCoach);
////    }
//}