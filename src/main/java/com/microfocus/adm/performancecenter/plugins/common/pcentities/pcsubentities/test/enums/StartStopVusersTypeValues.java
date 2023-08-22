package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum StartStopVusersTypeValues {
    SIMULTANEOUSLY("simultaneously"),
    GRADUALLY("gradually");

    private String value;

    private StartStopVusersTypeValues(String value) {
        this.value = value;
    }

    public static StartStopVusersTypeValues get(String val) {
        for (StartStopVusersTypeValues startStopVusersTypeValues : StartStopVusersTypeValues.values()) {
            if (val.equals(startStopVusersTypeValues.value()))
                return startStopVusersTypeValues;
        }
        return null;
    }

    public String value() {
        return value;
    }

}
