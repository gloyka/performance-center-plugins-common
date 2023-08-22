package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum LogOptionsTypeValues {

    ON_ERROR("on error"),
    ALWAYS("always");

    private String value;

    private LogOptionsTypeValues(String value) {
        this.value = value;
    }

    public static LogOptionsTypeValues get(String val) {
        for (LogOptionsTypeValues logOptionsTypeValues : LogOptionsTypeValues.values()) {
            if (val.equals(logOptionsTypeValues.value()))
                return logOptionsTypeValues;
        }
        return null;
    }

    public String value() {
        return value;
    }
}
