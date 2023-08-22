package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.enums;

public enum GoalCannotBeReachedActionValues {

    STOP_SCENARIO_AND_SAVE_RESULTS("StopScenarioAndSaveResults"),
    CONTINUE_WITHOUT_REACHING("ContinueWithoutReaching");

    private String value;

    private GoalCannotBeReachedActionValues(String value) {
        this.value = value;
    }

    public static GoalCannotBeReachedActionValues get(String val) {
        for (GoalCannotBeReachedActionValues goalCannotBeReachedActionValues : GoalCannotBeReachedActionValues.values()) {
            if (val.equals(goalCannotBeReachedActionValues.value()))
                return goalCannotBeReachedActionValues;
        }
        return null;
    }

    public String value() {
        return value;
    }

}
