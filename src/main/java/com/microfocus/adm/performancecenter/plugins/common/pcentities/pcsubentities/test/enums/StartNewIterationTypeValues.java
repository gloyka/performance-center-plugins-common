package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum StartNewIterationTypeValues {


    IMMEDIATELY("immediately"),
    FIXED_DELAY("fixed delay"),
    RANDOM_DELAY("random delay"),
    FIXED_INTERVAL("fixed interval"),
    RANDOM_INTERVAL("random interval");

    private String value;

    private StartNewIterationTypeValues(String value) {
        this.value = value;
    }

    public static StartNewIterationTypeValues get(String val) {
        for (StartNewIterationTypeValues startNewIterationTypeValues : StartNewIterationTypeValues.values()) {
            if (val.equals(startNewIterationTypeValues.value()))
                return startNewIterationTypeValues;
        }
        return null;
    }

    public String value() {
        return value;
    }

}
