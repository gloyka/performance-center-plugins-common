package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.scheduler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Scheduler {

    //optional
    int rampuptimeinseconds;

    //optional
    int durationinseconds;

//    public Scheduler(int rampuptimeinseconds, int durationinseconds) {
//        this.rampuptimeinseconds = rampuptimeinseconds;
//        this.durationinseconds = durationinseconds;
//    }

    @Override
    public String toString() {
        return "Scheduler {" +
                "rampuptimeinseconds = " + rampuptimeinseconds + ", " +
                "durationinseconds = " + durationinseconds + "}";
    }
}
