package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum HostNameLGValues {

    LG1("LG1"),
    LG2("LG2"),
    LG3("LG3"),
    LG4("LG4"),
    LG5("LG5");

    private String value;

    private HostNameLGValues(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }


    public static HostNameLGValues get(String val){
        for (HostNameLGValues hostNameLGValues : HostNameLGValues.values()) {
            if (val.equals(hostNameLGValues.value()))
                return hostNameLGValues;
        }
        return null;
    }
}
