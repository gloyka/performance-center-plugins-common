package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum DurationTypeValues {

    INDEFINITELY("indefinitely"),
    RUN_FOR("run for"),
    UNTIL_COMPLETE("until completion");

    private String value;

    private DurationTypeValues(String value) {
        this.value = value;
    }

    public static DurationTypeValues get(String val) {
        for (DurationTypeValues durationTypeValues : DurationTypeValues.values()) {
            if (val.equals(durationTypeValues.value()))
                return durationTypeValues;
        }
        return null;
    }

    public String value() {
        return value;
    }

}
