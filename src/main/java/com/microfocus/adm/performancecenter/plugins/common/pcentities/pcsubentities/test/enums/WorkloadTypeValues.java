package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum WorkloadTypeValues {

    BASIC("basic"),
    REAL_WORLD("real-world"),
    GOAL_ORIENTED("goal oriented");

    private String value;

    private WorkloadTypeValues(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }


    public static WorkloadTypeValues get(String val) {
        for (WorkloadTypeValues workloadTypeValues : WorkloadTypeValues.values()) {
            if (val.equals(workloadTypeValues.value()))
                return workloadTypeValues;
        }
        return null;
    }

}
