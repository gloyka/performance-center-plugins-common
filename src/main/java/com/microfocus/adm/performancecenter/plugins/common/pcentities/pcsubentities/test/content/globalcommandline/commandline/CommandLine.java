package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalcommandline.commandline;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalcommandline.GlobalCommandLine;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.jmeter.JMeter;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log.Log;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.thinktime.ThinkTime;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.pacing.Pacing;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Setter;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="CommandLine")
public class CommandLine {

    @XmlElement
    @XStreamAlias("Name")
    private String Name;

    @XmlElement
    @XStreamAlias("Value")
    private String Value;

    public CommandLine() { }

    public CommandLine(String name, String value) {
        setName(name);
        setValue(value);
    }


    @Override
    public String toString() {
        return "CommandLine{" +
                "Name = " + Name +
                ", Value = " + Value +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("CommandLine", CommandLine.class);
        xstream.aliasField("Name", CommandLine.class, "Name");
        xstream.aliasField("Value", CommandLine.class, "Value");
        xstream.aliasField("CommandLine", CommandLine.class, "CommandLine");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static CommandLine xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("CommandLine" , CommandLine.class);
        xstream.setClassLoader(CommandLine.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (CommandLine)xstream.fromXML(xml);
    }

}
