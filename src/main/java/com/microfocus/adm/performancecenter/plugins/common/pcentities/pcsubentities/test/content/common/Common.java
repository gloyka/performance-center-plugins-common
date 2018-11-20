package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common;


public class Common {

    public static String integerToString(int value) {
        if(value > 0)
            return Integer.toString(value);
        else
            return null;
    }

    public static int stringToInteger(String value) {
        if (value != null && !value.isEmpty())
            return Integer.parseInt(value);
        else
            return 0;
    }
}
