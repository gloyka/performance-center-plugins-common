package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum HostTypeValues {

    SPECIFIC("specific"),
    AUTOMATCH("automatch"),
    DYNAMIC("dynamic");

    private String value;

    private HostTypeValues(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }


    public static HostTypeValues get(String val){
        for (HostTypeValues hostTypeValues : HostTypeValues.values()) {
            if (val.equals(hostTypeValues.value()))
                return hostTypeValues;
        }
        return null;
    }

}
