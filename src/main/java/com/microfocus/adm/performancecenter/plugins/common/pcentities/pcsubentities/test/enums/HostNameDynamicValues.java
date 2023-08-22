package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum HostNameDynamicValues {

    DOCKER1("DOCKER1"),
    DOCKER2("DOCKER2"),
    DOCKER3("DOCKER3"),
    DOCKER4("DOCKER4"),
    DOCKER5("DOCKER5");

    private String value;

    private HostNameDynamicValues(String value) {
        this.value = value;
    }

    public static HostNameDynamicValues get(String val) {
        for (HostNameDynamicValues hostNameDynamicValues : HostNameDynamicValues.values()) {
            if (val.equals(hostNameDynamicValues.value()))
                return hostNameDynamicValues;
        }
        return null;
    }

    public String value() {
        return value;
    }


}
