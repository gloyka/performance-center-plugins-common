package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum LGDistributionTypeValues {

    ALL_TO_EACH_GROUP("all to each group"),
    MANUAL("manual");

    private String value;

    private LGDistributionTypeValues(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }


    public static LGDistributionTypeValues get(String val){
        for (LGDistributionTypeValues lgDistributionTypeValues : LGDistributionTypeValues.values()) {
            if (val.equals(lgDistributionTypeValues.value()))
                return lgDistributionTypeValues;
        }
        return null;
    }

}
