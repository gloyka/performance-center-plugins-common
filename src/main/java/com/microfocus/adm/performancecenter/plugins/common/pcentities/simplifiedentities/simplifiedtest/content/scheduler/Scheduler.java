package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.scheduler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Scheduler {

    //optional
    int rampup_seconds;

    //optional
    int duration_seconds;

//    public Scheduler(int rampup_seconds, int duration_seconds) {
//        this.rampup_seconds = rampup_seconds;
//        this.duration_seconds = duration_seconds;
//    }

    @Override
    public String toString() {
        return "Scheduler {" +
                "rampup_seconds = " + rampup_seconds + ", " +
                "duration_seconds = " + duration_seconds + "}";
    }
}
