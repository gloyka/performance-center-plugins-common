package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplifiedGroup {

    //default name will be used if not supplied
    String group_name;

    //1 vuser will be used if not supplied
    int vusers;

    //required if script_path not provided
    int script_id;

    //required if script_id not provided
    String script_path;

    //if supplied, it will be priorly considered even if lgamount was set
    String[] lg_name;

    //not supplied, will be retrieved later.
    String protocol;

    @Override
    public String toString() {
        return "SimplifiedGroup {" +
                "group_name = " + group_name +
                ", " + "vusers = " + vusers +
                ", " + "script_id = " + script_id +
                ", " + "script_path = " + script_path +
                ", " + "" + "lg_name = " + lg_name +
                ", " + "" + "protocol = " + protocol +
                "}";
    }
}
