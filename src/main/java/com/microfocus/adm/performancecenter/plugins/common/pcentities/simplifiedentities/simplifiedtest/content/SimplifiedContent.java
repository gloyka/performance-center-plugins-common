package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content;


import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.SimplifiedGroup;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.scheduler.Scheduler;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SimplifiedContent {

    //optional
    String controller;

    //optional if specified in group
    int lg_amount;

    //required
    private List<SimplifiedGroup> groups;

    //optional
    Scheduler scheduler;

    public SimplifiedContent() {}

    public SimplifiedContent(String controller, int lg_amount, List<SimplifiedGroup> groups, Scheduler scheduler) {
        this.controller = controller;
        this.lg_amount = lg_amount;
        this.groups = groups;
        this.scheduler = scheduler;
    }


    @Override
    public String toString() {
        return "SimplifiedContent {" +
                "controller = " + controller +
                ", " + "lg_amount = " + lg_amount +
                ", " + "groups = " + groups +
                ", " + "scheduler = " + scheduler +
                "}";
    }
}
