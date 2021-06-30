package com.microfocus.adm.performancecenter.plugins.common.pcentities;

public enum TimeslotPostRunAction {
    CollateOnly("CollateOnly"),
    CollateAnalyze("CollateAnalyze"),
    DoNothing("DoNothing");

    private String value;

    private TimeslotPostRunAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
