package com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.common.Common;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.javavm.javaenvclasspaths.JavaEnvClassPaths;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log.Log;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.log.logoptions.LogOptions;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.pacing.startnewiteration.StartNewIteration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.thinktime.ThinkTime;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.script.Script;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.host.Host;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.groups.rts.RTS ;

import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.Scheduler;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.Action;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.duration.Duration;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.initialize.Initialize;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.startgroup.StartGroup;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.startvusers.StartVusers;
import com.microfocus.adm.performancecenter.plugins.common.pcentities.pcsubentities.test.content.scheduler.actions.stopvusers.StopVusers;
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
@XmlRootElement(name="Group")
public class Group
{
    @XmlElement
    private String Name;

    @XmlElement
    private String Vusers;

    @XmlElement
    private Script Script;

    @XmlElement
    private ArrayList<Host> Hosts;

    @XmlElement
    private RTS RTS;

    @XmlElement
    private String GlobalCommandLine;

    @XmlElement
    private String CommandLine;

    @XmlElement
    private String GlobalRTS;

    @XmlElement
    private Scheduler Scheduler;

    public Group() {}

    public Group(String name, int vusers, Script script, ArrayList<Host> hosts, RTS RTS, String globalCommandLine, String commandLine, String globalRTS) {
        setName(name);
        setVusers(vusers);
        setScript(script);
        setHosts(hosts);
        setRTS(RTS);
        setGlobalCommandLine(globalCommandLine);
        setCommandLine(commandLine);
        setGlobalRTS(globalRTS);
    }

    public Group(String name, String vusers, Script script, ArrayList<Host> hosts, RTS RTS, String globalCommandLine, String commandLine, String globalRTS) {
        setName(name);
        setVusers(vusers);
        setScript(script);
        setHosts(hosts);
        setRTS(RTS);
        setGlobalCommandLine(globalCommandLine);
        setCommandLine(commandLine);
        setGlobalRTS(globalRTS);
    }

    public Group(String name, int vusers, Script script, ArrayList<Host> hosts, RTS RTS, String globalCommandLine, String commandLine, String globalRTS, Scheduler scheduler) {
        setName(name);
        setVusers(vusers);
        setScript(script);
        setHosts(hosts);
        setRTS(RTS);
        setGlobalCommandLine(globalCommandLine);
        setCommandLine(commandLine);
        setGlobalRTS(globalRTS);
        setScheduler(scheduler);
    }

    public Group(String name, String vusers, Script script, ArrayList<Host> hosts, RTS RTS, String globalCommandLine, String commandLine, String globalRTS, Scheduler scheduler) {
        setName(name);
        setVusers(vusers);
        setScript(script);
        setHosts(hosts);
        setRTS(RTS);
        setGlobalCommandLine(globalCommandLine);
        setCommandLine(commandLine);
        setGlobalRTS(globalRTS);
        setScheduler(scheduler);
    }

    public void setVusers(int value) {
        this.Vusers = Common.integerToString(value);
    }

    public void setVusers(String value) {
        this.Vusers = value;
    }


    @Override
    public String toString() {
        return "Group{" + "Name = " + Name +
                ", Vusers = " + Vusers +
                ", Script = " + Script +
                ", Hosts = " + Hosts +
                ", GlobalCommandLine = " + GlobalCommandLine +
                ", CommandLine = " + CommandLine +
                ", GlobalRTS = " + GlobalRTS +
                ", RTS = " + RTS +
                ", SimplifiedScheduler = " + Scheduler + "}";
    }

    public String objectToXML() {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Group", Group.class);
        xstream.aliasField("Name", Group.class, "Name");

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
        xstream.alias("Host", Host.class, Host.class);
        xstream.useAttributeFor(StopVusers.class, "Type");
        xstream.aliasField("Type", StopVusers.class, "Type");
        xstream.useAttributeFor(StartVusers.class, "Type");
        xstream.aliasField("Type", StartVusers.class, "Type");
        xstream.useAttributeFor(StartGroup.class, "Type");
        xstream.aliasField("Type", StartGroup.class, "Type");
        xstream.useAttributeFor(Initialize.class, "Type");
        xstream.aliasField("Type", Initialize.class, "Type");
        xstream.useAttributeFor(Duration.class, "Type");
        xstream.aliasField("Type", Duration.class, "Type");
        xstream.alias("Action", Action.class, Action.class);

        xstream.aliasField("Vusers", Group.class, "Vusers");
        xstream.aliasField("Script", Group.class, "Script");
        xstream.aliasField("Hosts", Group.class, "Hosts");
        xstream.aliasField("RTS", Group.class, "RTS");

        //JavaEnvClassPaths
        xstream.alias("JavaEnvClassPath", String.class);
        xstream.addImplicitCollection(JavaEnvClassPaths.class, "JavaEnvClassPath", "JavaEnvClassPath", String.class);

        xstream.aliasField("GlobalCommandLine", Group.class, "GlobalCommandLine");
        xstream.aliasField("CommandLine", Group.class, "CommandLine");
        xstream.aliasField("GlobalRTS", Group.class, "GlobalRTS");
        xstream.aliasField("SimplifiedScheduler", Group.class, "SimplifiedScheduler");
        xstream.aliasField("Group", Group.class, "Group");
        xstream.setMode(XStream.NO_REFERENCES);
        return xstream.toXML(this);
    }

    public static Group xmlToObject(String xml)
    {
        XStream xstream = new XStream();
        xstream = Helper.xstreamPermissions(xstream);
        xstream.alias("Group" , Group.class);

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
        xstream.alias("Host", Host.class,Host.class);
        xstream.useAttributeFor(StopVusers.class, "Type");
        xstream.aliasField("Type", StopVusers.class, "Type");
        xstream.useAttributeFor(StartVusers.class, "Type");
        xstream.aliasField("Type", StartVusers.class, "Type");
        xstream.useAttributeFor(StartGroup.class, "Type");
        xstream.aliasField("Type", StartGroup.class, "Type");
        xstream.useAttributeFor(Initialize.class, "Type");
        xstream.aliasField("Type", Initialize.class, "Type");
        xstream.useAttributeFor(Duration.class, "Type");
        xstream.aliasField("Type", Duration.class, "Type");
        xstream.alias("Action", Action.class, Action.class);
        xstream.omitField(Script.class, "ProtocolType" );

        //JavaEnvClassPaths
        xstream.alias("JavaEnvClassPath", String.class);
        xstream.addImplicitCollection(JavaEnvClassPaths.class, "JavaEnvClassPath", "JavaEnvClassPath", String.class);

        xstream.setClassLoader(Group.class.getClassLoader());
        xstream.setMode(XStream.NO_REFERENCES);
        return (Group)xstream.fromXML(xml);
    }

}