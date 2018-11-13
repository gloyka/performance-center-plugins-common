package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum VusersDistributionModeValues {

    BY_NUMBER("by number"),
    BY_PERCENTAGE("by percentage");

    private String value;

    private VusersDistributionModeValues(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }


    public static VusersDistributionModeValues get(String val){
        for (VusersDistributionModeValues vusersDistributionModeValues : VusersDistributionModeValues.values()) {
            if (val.equals(vusersDistributionModeValues.value()))
                return vusersDistributionModeValues;
        }
        return null;
    }
}
