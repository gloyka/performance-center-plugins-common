package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.jmeter.JMeter;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log.Log;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log.logoptions.LogOptions;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.pacing.startnewiteration.StartNewIteration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.thinktime.ThinkTime;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.pacing.Pacing;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.javavm.JavaVM;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Setter;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.security.PublicKey;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="RTS")
public class RTS
{
    @XmlElement(required = false)
    @XStreamAlias("Name")
    private String Name;

    @XmlElement(required = false)
    @XStreamAlias("Pacing")
    private Pacing Pacing;

    @XmlElement(required = false)
    @XStreamAlias("ThinkTime")
    private ThinkTime ThinkTime;

    @XmlElement(required = false)
    @XStreamAlias("Log")
    private Log Log;

    @XmlElement(required = false)
    @XStreamAlias("JMeter")
    private JMeter JMeter;

    @XmlElement(required = false)
    @XStreamAlias("JavaVM")
    private JavaVM JavaVM;

    public RTS () {}

    public RTS(String name, Pacing pacing, ThinkTime thinkTime, Log log, JMeter jMeter, JavaVM javaVM ) {
        setName(name);
        setPacing(pacing);
        setThinkTime(thinkTime);
        setLog(log);
        setJMeter(jMeter);
        setJavaVM(javaVM);
    }

    public RTS(Pacing pacing, ThinkTime thinkTime, Log log, JMeter jMeter, JavaVM javaVM ) {
        setPacing(pacing);
        setThinkTime(thinkTime);
        setLog(log);
        setJMeter(jMeter);
        setJavaVM(javaVM);
    }

    @Override
    public String toString() {
        return "RTS{" + "Name = " + Name +
                ", Pacing = " + Pacing +
                ", ThinkTimeTypeValues = " + ThinkTime +
                ", LogTypeValues = " + Log +
                ", JMeter = " + JMeter +
                ", JavaVM = " + JavaVM + "}";
    }


    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("RTS", RTS.class);
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
        xstream.aliasField("JMeter", RTS.class, "JMeter");
        xstream.aliasField("JavaVM", RTS.class, "JavaVM");
        xstream.aliasField("RTS", RTS.class, "RTS");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static RTS xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("RTS" , RTS.class);
        xstream.useAttributeFor(StartNewIteration.class, "Type");
        xstream.aliasField("Type", StartNewIteration.class, "Type");
        xstream.aliasField("Log", RTS.class, "Log");
        xstream.useAttributeFor(ThinkTime.class, "Type");
        xstream.aliasField("Type", ThinkTime.class, "Type");
        xstream.useAttributeFor(Log.class, "Type");
        xstream.aliasField("LogOptions", Log.class, "LogOptions");
        xstream.useAttributeFor(LogOptions.class, "Type");
        xstream.setClassLoader(RTS.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (RTS)xstream.fromXML(xml);
    }

}