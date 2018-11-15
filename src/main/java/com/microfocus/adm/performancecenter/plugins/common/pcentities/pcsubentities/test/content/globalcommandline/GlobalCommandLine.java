package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalcommandline;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.globalcommandline.commandline.CommandLine;

import com.microfocus.adm.performancecenter.plugins.common.utils.Helper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
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
@XmlRootElement(name="GlobalCommandLine")
public class GlobalCommandLine {

    @XmlElement
    @XStreamImplicit
    private ArrayList<CommandLine> CommandLine;

    public GlobalCommandLine() { }

    public GlobalCommandLine(ArrayList<CommandLine>  commandLine) {
        setCommandLine(commandLine);
    }

    @Override
    public String toString() {
        return "GlobalCommandLine{" +
                "CommandLine = " + CommandLine +
                "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("GlobalCommandLine", GlobalCommandLine.class);

        xstream.addImplicitCollection(GlobalCommandLine.class, "CommandLine");
        xstream.alias("CommandLine", CommandLine.class,CommandLine.class);

        xstream.aliasField("GlobalCommandLine", GlobalCommandLine.class, "GlobalCommandLine");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static GlobalCommandLine xmlToObject(String xml) {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("GlobalCommandLine" , GlobalCommandLine.class);

        xstream.addImplicitCollection(GlobalCommandLine.class, "CommandLine");
        xstream.alias("CommandLine", CommandLine.class,CommandLine.class);

        xstream.aliasField("GlobalCommandLine", GlobalCommandLine.class, "GlobalCommandLine");
        xstream.setClassLoader(GlobalCommandLine.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (GlobalCommandLine)xstream.fromXML(xml);
    }

}
