package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum MaxRunsReachedOptionValues {

    DO_NOT_PUBLISH_ADDITIONAL_RUNS("DoNotPublishAdditionalRuns"),
    DELETE_FIRST_SET_NEW_BASELINE("DeleteFirstSetNewBaseline");

    private String value;

    private MaxRunsReachedOptionValues(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }


    public static MaxRunsReachedOptionValues get(String val){
        for (MaxRunsReachedOptionValues maxRunsReachedOptionValues : MaxRunsReachedOptionValues.values()) {
            if (val.equals(maxRunsReachedOptionValues.value()))
                return maxRunsReachedOptionValues;
        }
        return null;
    }
}
