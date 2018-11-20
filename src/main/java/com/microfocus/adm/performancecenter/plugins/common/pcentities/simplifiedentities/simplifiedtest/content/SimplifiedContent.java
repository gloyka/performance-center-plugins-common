package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content;


import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.SimplifiedGroup;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.scheduler.Scheduler;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SimplifiedContent {

    //optional
    String controller;

    //optional if specified in group
    int lg_amount;

    //required
    private List<SimplifiedGroup> group;

    //optional
    Scheduler scheduler;

    public SimplifiedContent() {}

    public SimplifiedContent(String controller, int lg_amount, List<SimplifiedGroup> group, Scheduler scheduler) {
        this.controller = controller;
        this.lg_amount = lg_amount;
        this.group = group;
        this.scheduler = scheduler;
    }


    @Override
    public String toString() {
        return "SimplifiedContent {" +
                "controller = " + controller +
                ", " + "lg_amount = " + lg_amount +
                ", " + "group = " + group +
                ", " + "scheduler = " + scheduler +
                "}";
    }



    public String objectToXML() {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Content", SimplifiedContent.class);
        xstream.aliasField("controller", SimplifiedContent.class, "controller");
        xstream.aliasField("lg_amount", SimplifiedContent.class, "lg_amount");
        //xstream.aliasField("group", SimplifiedContent.class, "group");

        xstream.alias("group", SimplifiedGroup.class);
        xstream.addImplicitCollection(SimplifiedContent.class, "group", "group", SimplifiedGroup.class);

        xstream.aliasField("scheduler", SimplifiedContent.class, "scheduler");

        xstream.alias("lg_name", String.class);
        xstream.addImplicitCollection(SimplifiedGroup.class, "lg_name", "lg_name", String.class);

        xstream.aliasField("Content", SimplifiedContent.class, "SimplifiedContent");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static SimplifiedContent xmlToObject(String xml) {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Content" , SimplifiedContent.class);

        xstream.alias("group", SimplifiedGroup.class);
        xstream.addImplicitCollection(SimplifiedContent.class, "group", "group", SimplifiedGroup.class);

        xstream.alias("lg_name", String.class);
        xstream.addImplicitCollection(SimplifiedGroup.class, "lg_name", "lg_name", String.class);

        xstream.setClassLoader(SimplifiedContent.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SimplifiedContent)xstream.fromXML(xml);
    }
}
