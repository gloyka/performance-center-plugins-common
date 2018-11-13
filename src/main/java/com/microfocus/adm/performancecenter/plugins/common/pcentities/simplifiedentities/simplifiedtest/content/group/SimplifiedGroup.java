package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplifiedGroup {

    //default name will be used if not supplied
    String groupname;

    //1 vuser will be used if not supplied
    int vusers;

    //required if scriptfullname not provided
    int scriptid;

    //required if scriptid not provided
    String scriptfullname;

    //if supplied, it will be priorly considered even if lgamount was set
    String[] lgname;

    //not supplied, will be retrieved later.
    String protocol;

    @Override
    public String toString() {
        return "SimplifiedGroup {" +
                "groupname = " + groupname +
                ", " + "vusers = " + vusers +
                ", " + "scriptid = " + scriptid +
                ", " + "scriptfullname = " + scriptfullname +
                ", " + "" + "lgname = " + lgname +
                ", " + "" + "protocol = " + protocol +
                "}";
    }
}
