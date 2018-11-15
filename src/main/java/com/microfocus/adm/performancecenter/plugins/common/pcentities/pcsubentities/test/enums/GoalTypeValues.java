package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum GoalTypeValues {

    VIRTUAL_USERS("VirtualUsers"),
    HITS_PER_SECOND("HitsPerSecond"),
    TRANSACTIONS_PER_SECOND("TransactionsPerSecond");

    private String value;

    private GoalTypeValues(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }


    public static GoalTypeValues get(String val){
        for (GoalTypeValues goalTypeValues : GoalTypeValues.values()) {
            if (val.equals(goalTypeValues.value()))
                return goalTypeValues;
        }
        return null;
    }

}
