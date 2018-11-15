package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum LogTypeValues {
    DISABLE("disable"),
    IGNORE("ignore"),
    STANDARD("standard"),
    EXTENDED("extended");

    private String value;

    private LogTypeValues(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }


    public static LogTypeValues get(String val){
        for (LogTypeValues logTypeValues : LogTypeValues.values()) {
            if (val.equals(logTypeValues.value()))
                return logTypeValues;
        }
        return null;
    }


}
