package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.enums;

public enum SimplifiedThinkTimeTypeValues {

    IGNORE("ignore"),
    REPLAY("replay"),
    MODIFY("modify"),
    RANDOM("random");

    private String value;

    private SimplifiedThinkTimeTypeValues(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }


    public static SimplifiedThinkTimeTypeValues get(String val){
        for (SimplifiedThinkTimeTypeValues simplifiedThinkTimeTypeValues : SimplifiedThinkTimeTypeValues.values()) {
            if (val.equals(simplifiedThinkTimeTypeValues.value()))
                return simplifiedThinkTimeTypeValues;
        }
        return null;
    }
}
