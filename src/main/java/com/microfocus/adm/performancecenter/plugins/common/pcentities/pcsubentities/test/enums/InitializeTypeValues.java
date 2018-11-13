package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum InitializeTypeValues {

    GRADUALLY("gradually"),
    JUST_BEFORE_VUSER_RUNS("just before vuser runs"),
    SIMULTANEOUSLY("simultaneously");

    private String value;

    private InitializeTypeValues(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }


    public static InitializeTypeValues get(String val){
        for (InitializeTypeValues initializeTypeValues : InitializeTypeValues.values()) {
            if (val.equals(initializeTypeValues.value()))
                return initializeTypeValues;
        }
        return null;
    }

}
