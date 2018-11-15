package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.scheduler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Scheduler {

    //optional
    int rampup;

    //optional
    int duration;

//    public Scheduler(int rampup, int duration) {
//        this.rampup = rampup;
//        this.duration = duration;
//    }

    @Override
    public String toString() {
        return "Scheduler {" +
                "rampup = " + rampup + ", " +
                "duration = " + duration + "}";
    }
}
