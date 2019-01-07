package com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.elasticconfiguration.SimplifiedElasticConfiguration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.SimplifiedGroup;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.group.rts.javavm.SimplifiedJavaVM;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.simplifiedentities.simplifiedtest.content.scheduler.SimplifiedScheduler;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@JsonIgnoreProperties
public class SimplifiedContent {

    //optional
    private String controller;

    //optional if specified in group
    private int lg_amount;

    //required
    private List<SimplifiedGroup> group;

    //optional
    private SimplifiedScheduler scheduler;

    //optional if docker not used
    private SimplifiedElasticConfiguration lg_elastic_configuration;

    private SimplifiedElasticConfiguration controller_elastic_configuration;

    public SimplifiedContent() {}

    public SimplifiedContent(String controller, int lg_amount, List<SimplifiedGroup> group, SimplifiedScheduler scheduler,
                             SimplifiedElasticConfiguration lg_elastic_configuration, SimplifiedElasticConfiguration controller_elastic_configuration) {
        this.controller = controller;
        this.lg_amount = lg_amount;
        this.group = group;
        this.scheduler = scheduler;
        this.lg_elastic_configuration = lg_elastic_configuration;
        this.controller_elastic_configuration = controller_elastic_configuration;
    }


    @Override
    public String toString() {
        return "SimplifiedContent {" +
                "controller = " + controller +
                ", " + "lg_amount = " + lg_amount +
                ", " + "group = " + group +
                ", " + "scheduler = " + scheduler +
//                ", " + "lg_elastic_configuration = " + lg_elastic_configuration +
                ", " + "controller_elastic_configuration = " + controller_elastic_configuration +
                "}";
    }



    public String objectToXML() {
        XStream xstream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("_-", "_")));
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Content", SimplifiedContent.class);
        xstream.aliasField("controller", SimplifiedContent.class, "controller");
        xstream.aliasField("lg_amount", SimplifiedContent.class, "lg_amount");

        xstream.alias("java_env_class_paths", String.class);
        xstream.addImplicitCollection(SimplifiedJavaVM.class, "java_env_class_paths", "java_env_class_paths", String.class);

        xstream.alias("group", SimplifiedGroup.class);
        xstream.addImplicitCollection(SimplifiedContent.class, "group", "group", SimplifiedGroup.class);

        xstream.aliasField("scheduler", SimplifiedContent.class, "scheduler");
        xstream.aliasField("lg_elastic_configuration", SimplifiedContent.class, "lg_elastic_configuration");
        xstream.aliasField("controller_elastic_configuration", SimplifiedContent.class, "controller_elastic_configuration");

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

        xstream.alias("java_env_class_paths", String.class);
        xstream.addImplicitCollection(SimplifiedJavaVM.class, "java_env_class_paths", "java_env_class_paths", String.class);

        xstream.alias("group", SimplifiedGroup.class);
        xstream.addImplicitCollection(SimplifiedContent.class, "group", "group", SimplifiedGroup.class);

        xstream.alias("lg_name", String.class);
        xstream.addImplicitCollection(SimplifiedGroup.class, "lg_name", "lg_name", String.class);

        xstream.setClassLoader(SimplifiedContent.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (SimplifiedContent)xstream.fromXML(xml);
    }
}
