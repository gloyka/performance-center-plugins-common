package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.enums;

public enum SimplifiedPacingTypeValues {
    IMMEDIATELY("immediately"),
    FIXED_DELAY("fixed delay"),
    RANDOM_DELAY("random delay"),
    FIXED_INTERVAL("fixed interval"),
    RANDOM_INTERVAL("random interval");

    private String value;

    private SimplifiedPacingTypeValues(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }


    public static SimplifiedPacingTypeValues get(String val){
        for (SimplifiedPacingTypeValues simplifiedPacingTypeValues : SimplifiedPacingTypeValues.values()) {
            if (val.equals(simplifiedPacingTypeValues.value()))
                return simplifiedPacingTypeValues;
        }
        return null;
    }
}
