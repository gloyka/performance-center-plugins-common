package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsimplifiedentities.enums;

public enum ControllerTypeValues {

    AUTOMATCH("Automatch"),
    SPECIFIC("Specific"),
    DOCKER("Docker");

    private String value;

    private ControllerTypeValues(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }


    public static ControllerTypeValues get(String val){
        for (ControllerTypeValues controllerTypeValues : ControllerTypeValues.values()) {
            if (val.equals(controllerTypeValues.value()))
                return controllerTypeValues;
        }
        return null;
    }
}
