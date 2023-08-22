package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum LoadCriterionValues {

    RUNNING_VUSERS("running_vusers"),
    THROUGHPUT("throughput"),
    HITS_PER_SECOND("hits_per_second"),
    TRANSACTION_PER_SECOND("transactions_per_second");

    private String value;

    private LoadCriterionValues(String value) {
        this.value = value;
    }

    public static LoadCriterionValues get(String val) {
        for (LoadCriterionValues loadCriterionValues : LoadCriterionValues.values()) {
            if (val.equals(loadCriterionValues.value()))
                return loadCriterionValues;
        }
        return null;
    }

    public String value() {
        return value;
    }

}
