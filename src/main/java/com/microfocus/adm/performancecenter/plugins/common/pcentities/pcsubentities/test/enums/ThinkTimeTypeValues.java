package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum ThinkTimeTypeValues {
    IGNORE("ignore"),
    REPLAY("replay"),
    MODIFY("modify"),
    RANDOM("random");

    private String value;

    private ThinkTimeTypeValues(String value) {
        this.value = value;
    }

    public static ThinkTimeTypeValues get(String val) {
        for (ThinkTimeTypeValues ThinkTimeTypeValues : ThinkTimeTypeValues.values()) {
            if (val.equals(ThinkTimeTypeValues.value()))
                return ThinkTimeTypeValues;
        }
        return null;
    }

    public String value() {
        return value;
    }
}
