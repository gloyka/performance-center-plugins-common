package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum StartGroupTypeValues {

    IMMEDIATELY("immediately"),
    WITH_DELAY("with delay"),
    WHEN_GROUP_FINISHES("when group finishes");

    private String value;

    private StartGroupTypeValues(String value) {
        this.value = value;
    }

    public static StartGroupTypeValues get(String val) {
        for (StartGroupTypeValues startGroupTypeValues : StartGroupTypeValues.values()) {
            if (val.equals(startGroupTypeValues.value()))
                return startGroupTypeValues;
        }
        return null;
    }

    public String value() {
        return value;
    }
}
