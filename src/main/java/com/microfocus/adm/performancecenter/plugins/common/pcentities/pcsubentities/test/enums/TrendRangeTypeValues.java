package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;


public enum TrendRangeTypeValues {

    COMPLETE_RUN("CompleteRun"),
    PART_OF_RUN("PartOfRun");

    private String value;

    private TrendRangeTypeValues(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static TrendRangeTypeValues get(String val){
        for (TrendRangeTypeValues trendRangeTypeValues : TrendRangeTypeValues.values()) {
            if (val.equals(trendRangeTypeValues.value()))
                return trendRangeTypeValues;
        }
        return null;
    }

}


