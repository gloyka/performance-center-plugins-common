package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.SimplifiedRTS;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.javavm.SimplifiedJavaVM;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.thinktime.SimplifiedThinkTime;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplifiedGroup {

    //default name will be used if not supplied
    private String group_name;

    //1 vuser will be used if not supplied
    private int vusers;

    //required if script_path not provided
    private int script_id;

    //required if script_id not provided
    private String script_path;

    //if supplied, it will be considered first even if lgamount was set
    private String[] lg_name;

    //not supplied, will be retrieved later.
    private String protocol;

    //not supplied, will be retrieved later.
    private String command_line;

    private SimplifiedRTS rts;

    public SimplifiedGroup() {}

    public SimplifiedGroup(String group_name, int vusers, int script_id, String script_path, String[] lg_name) {
        this.group_name = group_name;
        this.vusers = vusers;
        this.script_id = script_id;
        this.script_path = script_path;
        this.lg_name = lg_name;
    }

    public void setValuesToSimplifiedGroup(String group_name, int vusers, int script_id, String script_path, String[] lg_name) {
        this.group_name = group_name;
        this.vusers = vusers;
        this.script_id = script_id;
        this.script_path = script_path;
        this.lg_name = lg_name;
    }

    @Override
    public String toString() {
        return "SimplifiedGroup {" +
                "group_name = " + group_name +
                ", " + "vusers = " + vusers +
                ", " + "script_id = " + script_id +
                ", " + "script_path = " + script_path +
                ", " + "" + "lg_name = " + lg_name +
                ", " + "" + "protocol = " + protocol +
                ", " + "" + "command_line = " + command_line +
                ", " + "" + "rts = " + rts +
                "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedGroup", SimplifiedGroup.class);
        xstream.aliasField("group_name", SimplifiedGroup.class, "group_name");
        xstream.aliasField("vusers", SimplifiedGroup.class, "vusers");
        xstream.aliasField("script_id", SimplifiedGroup.class, "script_id");
        xstream.aliasField("script_path", SimplifiedGroup.class, "script_path");
        xstream.aliasField("command_line", SimplifiedGroup.class, "command_line");
        xstream.aliasField("rts", SimplifiedGroup.class, "rts");

        xstream.alias("lg_name", String.class);
        xstream.addImplicitCollection(SimplifiedGroup.class, "lg_name", "lg_name", String.class);

        xstream.alias("java_env_class_paths", String.class);
        xstream.addImplicitCollection(SimplifiedJavaVM.class, "java_env_class_paths", "java_env_class_paths", String.class);

        xstream.aliasField("protocol", SimplifiedGroup.class, "protocol");
        xstream.aliasField("command_line", SimplifiedGroup.class, "command_line");
        xstream.aliasField("rts", SimplifiedGroup.class, "rts");
        xstream.aliasField("SimplifiedGroup", SimplifiedGroup.class, "SimplifiedGroup");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static SimplifiedGroup xmlToObject(String xml) {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("SimplifiedGroup" , SimplifiedGroup.class);

        xstream.alias("lg_name", String.class);
        xstream.addImplicitCollection(SimplifiedGroup.class, "lg_name", "lg_name", String.class);

        xstream.alias("java_env_class_paths", String.class);
        xstream.addImplicitCollection(SimplifiedJavaVM.class, "java_env_class_paths", "java_env_class_paths", String.class);

        xstream.setClassLoader(SimplifiedGroup.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SimplifiedGroup)xstream.fromXML(xml);
    }
}
