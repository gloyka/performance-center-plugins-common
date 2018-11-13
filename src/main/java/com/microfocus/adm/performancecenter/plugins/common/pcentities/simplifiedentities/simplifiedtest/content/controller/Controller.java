package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Controller {

    String type;

    String name;

//    public Controller(String type, String name) {
//        this.type = type;
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "Controller {" +
                "type = " + type + ", " +
                "name = " + name + "}";
    }
}
