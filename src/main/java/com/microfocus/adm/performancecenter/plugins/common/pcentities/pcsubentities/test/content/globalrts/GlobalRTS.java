package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalrts;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.RTS;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.javavm.javaenvclasspaths.JavaEnvClassPaths;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log.Log;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log.logoptions.LogOptions;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.pacing.startnewiteration.StartNewIteration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.thinktime.ThinkTime;
import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import lombok.Setter;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="GlobalRTS")
public class GlobalRTS {

    @XmlElement
    private ArrayList<RTS> RTS;

    public GlobalRTS(){}

    public GlobalRTS(ArrayList<RTS> rts) {
        setRTS(rts);
    }

    @Override
    public String toString() {
        return "GlobalRTS{" + "RTS = " + RTS + "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);

        xstream.alias("GlobalRTS", GlobalRTS.class);
        xstream.addImplicitCollection(GlobalRTS.class, "RTS");
        xstream.alias("RTS", RTS.class,RTS.class);
        xstream.aliasField("Name", RTS.class, "Name");
        xstream.aliasField("Type", Log.class, "Type");
        xstream.aliasField("Pacing", RTS.class, "Pacing");
        xstream.useAttributeFor(StartNewIteration.class, "Type");
        xstream.aliasField("Type", StartNewIteration.class, "Type");
        xstream.aliasField("ThinkTime", RTS.class, "ThinkTime");
        xstream.useAttributeFor(ThinkTime.class, "Type");
        xstream.aliasField("Type", ThinkTime.class, "Type");
        xstream.aliasField("Log", RTS.class, "Log");
        xstream.useAttributeFor(Log.class, "Type");
        xstream.aliasField("LogOptions", Log.class, "LogOptions");
        xstream.useAttributeFor(LogOptions.class, "Type");
        xstream.aliasField("GlobalRTS", GlobalRTS.class, "GlobalRTS");

        //JavaEnvClassPaths
        xstream.alias("JavaEnvClassPath", String.class);
        xstream.addImplicitCollection(JavaEnvClassPaths.class, "JavaEnvClassPath", "JavaEnvClassPath", String.class);

        xstream.setMode(XStream.NO_REFERENCES);
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);

    }

    public static GlobalRTS xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("GlobalRTS" , GlobalRTS.class);

        xstream.addImplicitCollection(GlobalRTS.class, "RTS");
        xstream.alias("RTS", RTS.class,RTS.class);
        xstream.useAttributeFor(StartNewIteration.class, "Type");
        xstream.aliasField("Type", StartNewIteration.class, "Type");
        xstream.aliasField("Log", RTS.class, "Log");
        xstream.useAttributeFor(ThinkTime.class, "Type");
        xstream.aliasField("Type", ThinkTime.class, "Type");
        xstream.useAttributeFor(Log.class, "Type");
        xstream.aliasField("LogOptions", Log.class, "LogOptions");
        xstream.useAttributeFor(LogOptions.class, "Type");

        //JavaEnvClassPaths
        xstream.alias("JavaEnvClassPath", String.class);
        xstream.addImplicitCollection(JavaEnvClassPaths.class, "JavaEnvClassPath", "JavaEnvClassPath", String.class);

        xstream.setClassLoader(GlobalRTS.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.setMode(XStream.NO_REFERENCES);
        return (GlobalRTS)xstream.fromXML(xml);
    }
}