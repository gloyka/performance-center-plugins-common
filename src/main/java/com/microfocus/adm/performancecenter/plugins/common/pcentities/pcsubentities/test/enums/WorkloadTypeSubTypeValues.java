package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum WorkloadTypeSubTypeValues {

    BY_TEST("by test"),
    BY_GROUP("by group");

    private String value;

    private WorkloadTypeSubTypeValues(String value) {
        this.value = value;
    }

    public static WorkloadTypeSubTypeValues get(String val) {
        for (WorkloadTypeSubTypeValues workloadTypeSubTypeValues : WorkloadTypeSubTypeValues.values()) {
            if (val.equals(workloadTypeSubTypeValues.value()))
                return workloadTypeSubTypeValues;
        }
        return null;
    }

    public String value() {
        return value;
    }

}
